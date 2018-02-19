package com.matthiasbruns.kleanarchitekture.presentation.post.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import javax.inject.Inject

class PresentationPostCommentMapper @Inject constructor() : Mapper<Comment, PresentationPostComment> {

    override fun map(from: Comment): PresentationPostComment = with(from) {
        PresentationPostComment(
                id = id,
                postId = postId,
                name = name,
                body = body,
                email = email,
                maskedEmail = when (email.length > 4) {
                    true -> email.replaceRange(2, email.length - 2, "*****@*****")
                    false -> email
                }
        )
    }
}