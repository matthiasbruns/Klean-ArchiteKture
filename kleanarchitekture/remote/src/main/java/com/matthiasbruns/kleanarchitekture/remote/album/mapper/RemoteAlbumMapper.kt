package com.matthiasbruns.kleanarchitekture.remote.album.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.album.model.AlbumEntry
import com.matthiasbruns.kleanarchitekture.remote.album.model.RemoteAlbum
import javax.inject.Inject

class RemoteAlbumMapper @Inject constructor() : Mapper<RemoteAlbum, AlbumEntry> {

    override fun map(from: RemoteAlbum): AlbumEntry = with(from) {
        AlbumEntry(id = id,
                userId = userId,
                title = title)
    }
}