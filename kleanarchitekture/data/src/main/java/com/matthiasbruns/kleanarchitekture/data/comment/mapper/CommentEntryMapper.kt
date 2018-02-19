package com.matthiasbruns.kleanarchitekture.data.comment.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.comment.model.CommentEntry
import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import javax.inject.Inject

class CommentEntryMapper @Inject constructor(): Mapper<CommentEntry, Comment> {

    override fun map(from: CommentEntry): Comment = with(from) {
        Comment(id = id,
                postId = postId,
                name = name,
                body = body,
                email = email)
    }
}