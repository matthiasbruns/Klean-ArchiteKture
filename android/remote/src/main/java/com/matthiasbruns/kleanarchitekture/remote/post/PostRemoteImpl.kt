package com.matthiasbruns.kleanarchitekture.remote.post

import com.matthiasbruns.kleanarchitekture.data.post.PostRemote
import com.matthiasbruns.kleanarchitekture.data.post.model.PostEntry
import com.matthiasbruns.kleanarchitekture.remote.ApiError
import com.matthiasbruns.kleanarchitekture.remote.post.mapper.RemotePostMapper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRemoteImpl @Inject constructor(private val api: PostApi,
                                         private val mapper: RemotePostMapper) : PostRemote {

    override fun fetch(): Single<List<PostEntry>> = api.fetch()
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }

    override fun fetch(max: Int): Single<List<PostEntry>> = api.fetch()
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.take(max).map(mapper::map) }
}