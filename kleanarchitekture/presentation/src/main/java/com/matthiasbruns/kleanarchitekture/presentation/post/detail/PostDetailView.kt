package com.matthiasbruns.kleanarchitekture.presentation.post.detail

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import io.reactivex.Observable

interface PostDetailView {

    val post: PresentationPost

    val onAuthorClick: Observable<Any>

    fun setPost(post: PresentationPost)

    fun setComments(comments: List<PresentationPostComment>)

    fun hideError()

    fun showError(throwable: Throwable)
}