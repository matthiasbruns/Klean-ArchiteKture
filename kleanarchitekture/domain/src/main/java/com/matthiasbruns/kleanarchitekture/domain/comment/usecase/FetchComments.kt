package com.matthiasbruns.kleanarchitekture.domain.comment.usecase

import com.matthiasbruns.kleanarchitekture.domain.NoArgUseCase
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import io.reactivex.Single
import javax.inject.Inject

class FetchComments @Inject constructor(private val repository: CommentRepository) : NoArgUseCase<Single<List<Comment>>> {

    override fun execute(): Single<List<Comment>> = repository.fetch()
}