package com.matthiasbruns.kleanarchitekture.remote.photo.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.photo.model.PhotoEntry
import com.matthiasbruns.kleanarchitekture.remote.photo.model.RemotePhoto
import javax.inject.Inject

class RemotePhotoMapper @Inject constructor() : Mapper<RemotePhoto, PhotoEntry> {

    override fun map(from: RemotePhoto): PhotoEntry = with(from) {
        PhotoEntry(id = id,
                albumId = albumId,
                title = title,
                thumbnailUrl = thumbnailUrl,
                url = url)
    }
}