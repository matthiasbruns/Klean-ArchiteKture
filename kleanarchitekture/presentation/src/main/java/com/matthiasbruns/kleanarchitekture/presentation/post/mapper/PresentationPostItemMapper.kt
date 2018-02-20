package com.matthiasbruns.kleanarchitekture.presentation.post.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import javax.inject.Inject

class PresentationPostItemMapper @Inject constructor() : Mapper<Post, PresentationPost> {

    override fun map(from: Post): PresentationPost = with(from) {
        PresentationPost(id = id,
                userId = userId,
                title = title,
                body = body,
                formattedUserId = "User: $userId") // cheap solution
    }
}