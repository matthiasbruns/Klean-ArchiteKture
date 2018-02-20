package com.matthiasbruns.kleanarchitekture.data.photo

import com.matthiasbruns.kleanarchitekture.data.photo.mapper.PhotoEntryMapper
import com.matthiasbruns.kleanarchitekture.domain.photo.PhotoRepository
import com.matthiasbruns.kleanarchitekture.domain.photo.model.Photo
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class DataPhotoRepository @Inject constructor(private val photoRemote: PhotoRemote,
                                              private val photoMapper: PhotoEntryMapper) : PhotoRepository {

    override fun fetch(): Single<List<Photo>> = photoRemote.fetch()
            .map { it.map(photoMapper::map) }

    override fun fetch(id: Int): Maybe<Photo> = photoRemote.fetch(id)
            .map(photoMapper::map)

    override fun fetchByAlbum(albumId: Int): Single<List<Photo>> = photoRemote.fetchByAlbum(albumId)
            .map { it.map(photoMapper::map) }
}