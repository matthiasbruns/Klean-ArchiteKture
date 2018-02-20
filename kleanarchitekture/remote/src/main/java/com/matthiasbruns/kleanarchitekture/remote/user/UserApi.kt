package com.matthiasbruns.kleanarchitekture.remote.user

import com.matthiasbruns.kleanarchitekture.remote.user.model.RemoteUser
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users")
    fun fetch(): Single<Result<List<RemoteUser>>>

    @GET("users/{id}")
    fun fetch(@Path("id") userId: Int): Single<Result<RemoteUser>>
}