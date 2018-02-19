package com.matthiasbruns.kleanarchitekture.data.comment

import com.matthiasbruns.kleanarchitekture.data.comment.model.CommentEntry
import io.reactivex.Single

interface CommentRemote {

    fun fetch(): Single<List<CommentEntry>>

    fun fetch(postId: Int): Single<List<CommentEntry>>
}