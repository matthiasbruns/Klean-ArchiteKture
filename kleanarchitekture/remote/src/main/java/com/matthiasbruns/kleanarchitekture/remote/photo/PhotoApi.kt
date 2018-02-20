package com.matthiasbruns.kleanarchitekture.remote.photo

import com.matthiasbruns.kleanarchitekture.remote.photo.model.RemotePhoto
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("photos")
    fun fetch(): Single<Result<List<RemotePhoto>>>

    @GET("photos")
    fun fetch(@Query("id") id: Int): Single<Result<RemotePhoto>>

    @GET("photos")
    fun fetchByAlbum(@Query("albumId") albumId: Int): Single<Result<List<RemotePhoto>>>
}