package com.matthiasbruns.kleanarchitekture.data.post

import com.matthiasbruns.kleanarchitekture.data.post.model.PostEntry
import io.reactivex.Single

interface PostRemote {

    fun fetch(): Single<List<PostEntry>>

    fun fetch(max: Int): Single<List<PostEntry>>
}