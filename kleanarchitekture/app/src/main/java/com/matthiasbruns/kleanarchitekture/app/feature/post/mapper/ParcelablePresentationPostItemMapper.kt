package com.matthiasbruns.kleanarchitekture.app.feature.post.mapper

import com.matthiasbruns.kleanarchitekture.app.feature.post.model.ParcelablePresentationPost
import com.matthiasbruns.kleanarchitekture.commons.data.BiDirectionalMapper
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import javax.inject.Inject

class ParcelablePresentationPostItemMapper @Inject constructor() : BiDirectionalMapper<PresentationPost, ParcelablePresentationPost> {

    override fun mapTo(from: PresentationPost): ParcelablePresentationPost = with(from) {
        ParcelablePresentationPost(id = id,
                userId = userId,
                title = title,
                body = body,
                formattedUserId = formattedUserId)
    }

    override fun mapFrom(from: ParcelablePresentationPost): PresentationPost = with(from) {
        PresentationPost(id = id,
                userId = userId,
                title = title,
                body = body,
                formattedUserId = formattedUserId)
    }
}