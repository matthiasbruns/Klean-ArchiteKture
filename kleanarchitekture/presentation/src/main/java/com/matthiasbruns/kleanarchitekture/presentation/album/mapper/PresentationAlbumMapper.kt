package com.matthiasbruns.kleanarchitekture.presentation.album.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationAlbum
import javax.inject.Inject

class PresentationAlbumMapper @Inject constructor(private val photoMapper: PresentationPhotoMapper) : Mapper<Album, PresentationAlbum> {

    override fun map(from: Album): PresentationAlbum = with(from) {
        PresentationAlbum(id = id,
                userId = userId,
                title = title,
                photos = photos.map(photoMapper::map))
    }
}