package com.matthiasbruns.kleanarchitekture.presentation.post.list.presenter

import com.matthiasbruns.kleanarchitekture.domain.post.PostInteractor
import com.matthiasbruns.kleanarchitekture.presentation.DisposablePresenter
import com.matthiasbruns.kleanarchitekture.presentation.PresenterConfig
import com.matthiasbruns.kleanarchitekture.presentation.post.PostNavigator
import com.matthiasbruns.kleanarchitekture.presentation.post.list.PostListView
import com.matthiasbruns.kleanarchitekture.presentation.post.mapper.PresentationPostItemMapper
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

class PostListPresenter @Inject constructor(private val view: PostListView,
                                            private val uiScheduler: Scheduler,
                                            private val interactor: PostInteractor,
                                            private val mapper: PresentationPostItemMapper,
                                            private val navigator: PostNavigator) : DisposablePresenter() {

    private val reloadPostsSubject: Subject<Any> by lazy { PublishSubject.create<Any>() }

    private val posts: Single<List<PresentationPostItem>>
        get() = interactor.fetchPosts.execute().map { it.map(mapper::map) }

    override fun onStart() {
        super.onStart()

        reloadPostsSubject
                .flatMapSingle { posts }
                .observeOn(uiScheduler)
                .subscribe { view.render(it) }
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
                .subscribe { navigator.openPostDetail(it.id) }
                .disposeOnStop()
    }
}