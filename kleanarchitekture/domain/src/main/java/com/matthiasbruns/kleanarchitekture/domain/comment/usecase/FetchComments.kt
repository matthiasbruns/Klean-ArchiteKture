package com.matthiasbruns.kleanarchitekture.domain.comment.usecase

import com.matthiasbruns.kleanarchitekture.domain.NoArgUseCase
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class FetchComments @Inject constructor(private val repository: CommentRepository) : NoArgUseCase<Single<List<Post>>> {

    override fun execute(): Single<List<Post>> = repository.fetch()
}