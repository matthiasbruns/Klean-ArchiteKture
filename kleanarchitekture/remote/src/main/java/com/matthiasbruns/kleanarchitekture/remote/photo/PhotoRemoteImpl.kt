package com.matthiasbruns.kleanarchitekture.remote.photo

import com.matthiasbruns.kleanarchitekture.data.photo.PhotoRemote
import com.matthiasbruns.kleanarchitekture.data.photo.model.PhotoEntry
import com.matthiasbruns.kleanarchitekture.remote.ApiError
import com.matthiasbruns.kleanarchitekture.remote.photo.mapper.RemotePhotoMapper
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoRemoteImpl @Inject constructor(private val api: PhotoApi,
                                          private val mapper: RemotePhotoMapper) : PhotoRemote {

    override fun fetch(): Single<List<PhotoEntry>> = api.fetch()
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }

    override fun fetch(id: Int): Maybe<PhotoEntry> = api.fetch(id)
            .subscribeOn(Schedulers.io())
            .toMaybe()
            .map { ApiError.handleResult(it) }
            .map(mapper::map)

    override fun fetchByAlbum(albumId: Int): Single<List<PhotoEntry>> = api.fetchByAlbum(albumId)
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }
}