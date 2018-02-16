package com.matthiasbruns.kleanarchitekture.data.post

import com.matthiasbruns.kleanarchitekture.data.post.mapper.PostEntryMapper
import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class DataPostRepository @Inject constructor(private val remote: PostRemote,
                                             private val mapper: PostEntryMapper) : PostRepository {

    override fun fetch(): Single<List<Post>> = remote.fetch()
            .map { it.map(mapper::map) }

    override fun fetch(max: Int): Single<List<Post>> = remote.fetch()
            .map { it.map(mapper::map) }
}