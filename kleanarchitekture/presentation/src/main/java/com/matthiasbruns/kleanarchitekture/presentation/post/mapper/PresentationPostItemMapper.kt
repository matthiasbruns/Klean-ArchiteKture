package com.matthiasbruns.kleanarchitekture.presentation.post.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import javax.inject.Inject

class PresentationPostItemMapper @Inject constructor() : Mapper<Post, PresentationPostItem> {

    override fun map(from: Post): PresentationPostItem = with(from) {
        PresentationPostItem(id = id,
                userId = userId,
                title = title,
                body = body)
    }
}