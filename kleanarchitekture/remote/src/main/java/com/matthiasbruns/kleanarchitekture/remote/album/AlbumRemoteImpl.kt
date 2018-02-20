package com.matthiasbruns.kleanarchitekture.remote.album

import com.matthiasbruns.kleanarchitekture.data.album.AlbumRemote
import com.matthiasbruns.kleanarchitekture.data.album.model.AlbumEntry
import com.matthiasbruns.kleanarchitekture.remote.ApiError
import com.matthiasbruns.kleanarchitekture.remote.album.mapper.RemoteAlbumMapper
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumRemoteImpl @Inject constructor(private val api: AlbumApi,
                                          private val mapper: RemoteAlbumMapper) : AlbumRemote {

    override fun fetch(): Single<List<AlbumEntry>> = api.fetch()
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }

    override fun fetch(id: Int): Maybe<AlbumEntry> = api.fetch(id)
            .subscribeOn(Schedulers.io())
            .toMaybe()
            .map { ApiError.handleResult(it) }
            .map(mapper::map)

    override fun fetchByUser(userId: Int): Single<List<AlbumEntry>> = api.fetchByUser(userId)
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }
}