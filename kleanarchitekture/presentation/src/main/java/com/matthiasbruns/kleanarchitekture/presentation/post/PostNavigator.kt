package com.matthiasbruns.kleanarchitekture.presentation.post

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost

interface PostNavigator {

    fun openPostDetail(post: PresentationPost)

    fun openPostAuthor(post: PresentationPost)
}