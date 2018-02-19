package com.matthiasbruns.kleanarchitekture.domain.post

import com.matthiasbruns.kleanarchitekture.domain.comment.usecase.FetchCommentsByPost
import com.matthiasbruns.kleanarchitekture.domain.post.usecase.FetchLatestPostsMax
import com.matthiasbruns.kleanarchitekture.domain.post.usecase.FetchLatestPosts
import javax.inject.Inject

class PostInteractor @Inject constructor(val fetchLatestPosts: FetchLatestPosts,
                                         val fetchLatestPostsMax: FetchLatestPostsMax,
                                         val fetchCommentsByPost: FetchCommentsByPost) {
}