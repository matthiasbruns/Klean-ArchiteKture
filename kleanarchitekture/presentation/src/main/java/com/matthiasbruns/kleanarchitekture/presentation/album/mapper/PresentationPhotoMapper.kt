package com.matthiasbruns.kleanarchitekture.presentation.album.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.album.model.Photo
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationPhoto
import javax.inject.Inject

class PresentationPhotoMapper @Inject constructor() : Mapper<Photo, PresentationPhoto> {

    override fun map(from: Photo): PresentationPhoto = with(from) {
        PresentationPhoto(id = id,
                url = url,
                thumbnailUrl = thumbnailUrl,
                title = title,
                albumId = albumId)
    }
}