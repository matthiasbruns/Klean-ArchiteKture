package com.matthiasbruns.kleanarchitekture.remote.post

import com.matthiasbruns.kleanarchitekture.remote.post.model.RemotePost
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun fetch(): Single<Result<List<RemotePost>>>

    @GET("posts/{id}")
    fun fetchById(): Single<Result<RemotePost>>
}