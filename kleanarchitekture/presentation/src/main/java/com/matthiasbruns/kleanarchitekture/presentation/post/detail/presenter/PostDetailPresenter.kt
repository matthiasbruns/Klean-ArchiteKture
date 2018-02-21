package com.matthiasbruns.kleanarchitekture.presentation.post.detail.presenter

import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.matthiasbruns.kleanarchitekture.domain.post.PostInteractor
import com.matthiasbruns.kleanarchitekture.presentation.DisposablePresenter
import com.matthiasbruns.kleanarchitekture.presentation.Presenter
import com.matthiasbruns.kleanarchitekture.presentation.PresenterConfig
import com.matthiasbruns.kleanarchitekture.presentation.post.PostNavigator
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.PostDetailView
import com.matthiasbruns.kleanarchitekture.presentation.post.mapper.PresentationPostCommentMapper
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

interface PostDetailPresenter : Presenter {

}

class PostDetailPresenterImpl @Inject constructor(private val view: PostDetailView,
                                                  private val uiScheduler: Scheduler,
                                                  private val interactor: PostInteractor,
                                                  private val logger: Logger,
                                                  private val mapper: PresentationPostCommentMapper,
                                                  private val navigator: PostNavigator) : DisposablePresenter(), PostDetailPresenter {

    private val comments: Single<List<PresentationPostComment>>
        get() = interactor.fetchCommentsByPost.execute(view.post.id)
                .map { it.map(mapper::map) }

    private val post: Observable<PresentationPost> by lazy {
        Observable.just(view.post)
                .cache()
    }

    override fun onStart() {
        super<DisposablePresenter>.onStart()

        post.observeOn(uiScheduler)
                .subscribeBy { view.setPost(it) }
                .disposeOnStop()


        comments.observeOn(uiScheduler)
                .subscribeBy(onSuccess = this::onCommentsResponse, onError = this::onCommentsError)
                .disposeOnStop()

        view.onAuthorClick
                .throttleFirst(PresenterConfig.INPUT_DEBOUNCE_DURATION, PresenterConfig.INPUT_DEBOUNCE_TIME)
                .flatMap { post }
                .observeOn(uiScheduler)
                .subscribeBy { navigator.openPostAuthor(it) }
                .disposeOnStop()
    }

    private fun onCommentsResponse(comments: List<PresentationPostComment>) {
        view.hideError()
        view.setComments(comments)
    }

    private fun onCommentsError(throwable: Throwable) {
        view.showError(throwable)
    }
}