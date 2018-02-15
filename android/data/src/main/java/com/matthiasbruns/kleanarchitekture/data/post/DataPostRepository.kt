package com.matthiasbruns.kleanarchitekture.data.post

import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class DataPostRepository @Inject constructor() : PostRepository {

    override fun fetch(): Single<List<Post>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetch(max: Int): Single<List<Post>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}