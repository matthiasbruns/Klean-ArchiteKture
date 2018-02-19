package com.matthiasbruns.kleanarchitekture.presentation.post.detail

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment

interface PostDetailView {

    val post: PresentationPost

    fun setPost(post: PresentationPost)

    fun setComments(comments: List<PresentationPostComment>)
}