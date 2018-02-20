package com.matthiasbruns.kleanarchitekture.data.album.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.MapperWithArgs
import com.matthiasbruns.kleanarchitekture.data.album.model.AlbumEntry
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import com.matthiasbruns.kleanarchitekture.domain.photo.model.Photo
import javax.inject.Inject

class AlbumEntryMapper @Inject constructor() : MapperWithArgs<AlbumEntry, Album, List<Photo>> {

    override fun map(from: AlbumEntry, args: List<Photo>): Album = with(from) {
        Album(id = id,
                userId = userId,
                title = title,
                photos = args)
    }
}