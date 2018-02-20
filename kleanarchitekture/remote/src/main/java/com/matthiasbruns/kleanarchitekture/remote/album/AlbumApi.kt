package com.matthiasbruns.kleanarchitekture.remote.album

import com.matthiasbruns.kleanarchitekture.remote.album.model.RemoteAlbum
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {

    @GET("albums")
    fun fetch(): Single<Result<List<RemoteAlbum>>>

    @GET("albums")
    fun fetch(@Query("id") id: Int): Single<Result<RemoteAlbum>>

    @GET("albums")
    fun fetchByUser(@Query("userId") userId: Int): Single<Result<List<RemoteAlbum>>>
}