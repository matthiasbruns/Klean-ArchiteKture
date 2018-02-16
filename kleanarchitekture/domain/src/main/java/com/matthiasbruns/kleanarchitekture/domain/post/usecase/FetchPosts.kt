package com.matthiasbruns.kleanarchitekture.domain.post.usecase

import com.matthiasbruns.kleanarchitekture.domain.NoArgUseCase
import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class FetchPosts @Inject constructor(private val repository: PostRepository) : NoArgUseCase<Single<List<Post>>> {

    override fun execute(): Single<List<Post>> = repository.fetch()
}