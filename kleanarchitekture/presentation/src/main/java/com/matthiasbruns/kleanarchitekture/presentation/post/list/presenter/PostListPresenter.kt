package com.matthiasbruns.kleanarchitekture.presentation.post.list.presenter

import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.matthiasbruns.kleanarchitekture.domain.post.PostInteractor
import com.matthiasbruns.kleanarchitekture.presentation.DisposablePresenter
import com.matthiasbruns.kleanarchitekture.presentation.Presenter
import com.matthiasbruns.kleanarchitekture.presentation.PresenterConfig
import com.matthiasbruns.kleanarchitekture.presentation.post.PostNavigator
import com.matthiasbruns.kleanarchitekture.presentation.post.list.PostListView
import com.matthiasbruns.kleanarchitekture.presentation.post.mapper.PresentationPostItemMapper
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

interface PostListPresenter : Presenter

class PostListPresenterImpl @Inject constructor(private val view: PostListView,
                                                private val uiScheduler: Scheduler,
                                                private val interactor: PostInteractor,
                                                private val logger: Logger,
                                                private val mapper: PresentationPostItemMapper,
                                                private val navigator: PostNavigator) : DisposablePresenter(), PostListPresenter {

    private val reloadPostsSubject: Subject<Any> by lazy { PublishSubject.create<Any>() }

    private val posts: Single<List<PresentationPost>>
        get() = interactor.fetchLatestPosts.execute()
                .map { it.map(mapper::map) }

    override fun onStart() {
        super<DisposablePresenter>.onStart()

        reloadPostsSubject
                .observeOn(uiScheduler)
                .doOnNext { view.setLoading(true) }
                .flatMapSingle {
                    posts.onErrorResumeNext { t: Throwable ->
                        Single.just<List<PresentationPost>>(emptyList())
                                .observeOn(uiScheduler)
                                .map {
                                    handleError(t)
                                    it
                                }
                    }
                }
                .observeOn(uiScheduler)
                .filter { it.isNotEmpty() }
                .subscribeBy(onNext = this::handleSuccess, onError = this::handleError)
                .disposeOnStop()

        subscribeToView()

        // Trigger post data loading
        reloadPostsSubject.onNext(Any())
    }

    private fun subscribeToView() {
        // React to post item clicks
        view.onPostClick
                .throttleFirst(PresenterConfig.INPUT_DEBOUNCE_DURATION, PresenterConfig.INPUT_DEBOUNCE_TIME)
                .observeOn(uiScheduler)
                .subscribe { navigator.openPostDetail(it) }
                .disposeOnStop()

        view.onRequestRefresh
                .throttleFirst(PresenterConfig.INPUT_DEBOUNCE_DURATION, PresenterConfig.INPUT_DEBOUNCE_TIME)
                .subscribe { reloadPostsSubject.onNext(Any()) }
                .disposeOnStop()
    }

    private fun handleSuccess(items: List<PresentationPost>) {
        view.setLoading(false)
        view.hideError()
        view.render(items)
    }

    private fun handleError(throwable: Throwable) {
        logger.e(throwable, "Error while loading posts.")

        view.setLoading(false)
        view.showError()
    }
}