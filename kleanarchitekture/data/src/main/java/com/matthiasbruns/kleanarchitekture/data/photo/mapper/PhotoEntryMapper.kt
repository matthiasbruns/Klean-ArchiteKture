package com.matthiasbruns.kleanarchitekture.data.photo.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.photo.model.PhotoEntry
import com.matthiasbruns.kleanarchitekture.domain.photo.model.Photo
import javax.inject.Inject

class PhotoEntryMapper @Inject constructor() : Mapper<PhotoEntry, Photo> {

    override fun map(from: PhotoEntry): Photo = with(from) {
        Photo(id = id,
                albumId = albumId,
                title = title,
                thumbnailUrl = thumbnailUrl,
                url = url)
    }
}