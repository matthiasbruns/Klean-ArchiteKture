package com.matthiasbruns.kleanarchitekture.domain.post

import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single

interface PostRepository {

    fun fetch(): Single<List<Post>>

    fun fetch(max: Int): Single<List<Post>>

}