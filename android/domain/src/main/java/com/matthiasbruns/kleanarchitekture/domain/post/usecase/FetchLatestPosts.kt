package com.matthiasbruns.kleanarchitekture.domain.post.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class FetchLatestPosts @Inject constructor(private val repository: PostRepository): UseCase<Int, Single<List<Post>>> {

    /**
     * @param param the amount of posts to be fetched
     */
    override fun execute(param: Int): Single<List<Post>> = repository.fetch(param)
}