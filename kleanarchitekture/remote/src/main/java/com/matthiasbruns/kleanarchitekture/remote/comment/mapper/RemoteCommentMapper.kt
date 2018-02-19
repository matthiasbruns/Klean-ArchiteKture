package com.matthiasbruns.kleanarchitekture.remote.comment.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.comment.model.CommentEntry
import com.matthiasbruns.kleanarchitekture.remote.comment.model.RemoteComment
import javax.inject.Inject

class RemoteCommentMapper @Inject constructor() : Mapper<RemoteComment, CommentEntry> {

    override fun map(from: RemoteComment): CommentEntry = with(from) {
        CommentEntry(id = id,
                postId = postId,
                email = email,
                body = body,
                name = name)
    }
}