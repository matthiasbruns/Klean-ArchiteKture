package com.matthiasbruns.kleanarchitekture.presentation.post.detail.presenter

import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import com.matthiasbruns.kleanarchitekture.domain.post.PostInteractor
import com.matthiasbruns.kleanarchitekture.presentation.DisposablePresenter
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.PostDetailView
import com.matthiasbruns.kleanarchitekture.presentation.post.mapper.PresentationPostCommentMapper
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PostDetailPresenter @Inject constructor(private val view: PostDetailView,
                                              private val uiScheduler: Scheduler,
                                              private val interactor: PostInteractor,
                                              private val logger: Logger,
                                              private val mapper: PresentationPostCommentMapper) : DisposablePresenter() {

    private val comments: Single<List<PresentationPostComment>>
        get() = interactor.fetchCommentsByPost.execute(view.post.id)
                .map { it.map(mapper::map) }

    override fun onStart() {
        super.onStart()

        view.setPost(view.post)

        comments
                .observeOn(uiScheduler)
                .subscribeBy(onSuccess = this::onCommentsResponse, onError = this::onCommentsError)
    }

    private fun onCommentsResponse(comments: List<PresentationPostComment>) {
        view.setComments(comments)
    }

    private fun onCommentsError(throwable: Throwable) {

    }
}