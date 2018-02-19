package com.matthiasbruns.kleanarchitekture.domain.comment

import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import io.reactivex.Single

interface CommentRepository {

    fun fetch(): Single<List<Comment>>

    fun fetch(postId: Int): Single<List<Comment>>
}