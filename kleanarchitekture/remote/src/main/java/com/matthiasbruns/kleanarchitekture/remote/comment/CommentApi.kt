package com.matthiasbruns.kleanarchitekture.remote.comment

import com.matthiasbruns.kleanarchitekture.remote.comment.model.RemoteComment
import io.reactivex.Single
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentApi {

    @GET("comments")
    fun fetch(): Single<Result<List<RemoteComment>>>

    @GET("comments")
    fun fetch(@Query("postId") postId: Int): Single<Result<List<RemoteComment>>>
}