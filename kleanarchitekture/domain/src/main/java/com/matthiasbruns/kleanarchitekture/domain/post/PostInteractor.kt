package com.matthiasbruns.kleanarchitekture.domain.post

import com.matthiasbruns.kleanarchitekture.domain.post.usecase.FetchLatestPosts
import com.matthiasbruns.kleanarchitekture.domain.post.usecase.FetchPosts
import javax.inject.Inject

class PostInteractor @Inject constructor(val fetchPosts: FetchPosts,
                                         val fetchLatestPosts: FetchLatestPosts) {
}