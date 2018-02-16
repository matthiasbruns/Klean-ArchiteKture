package com.matthiasbruns.kleanarchitekture.domain.comment

import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single

interface CommentRepository {

    fun fetch(): Single<List<Post>>

    fun fetch(postId: Int): Single<List<Post>>
}