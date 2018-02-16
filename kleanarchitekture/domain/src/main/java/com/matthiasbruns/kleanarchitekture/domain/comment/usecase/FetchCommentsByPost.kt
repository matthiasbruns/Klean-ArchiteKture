package com.matthiasbruns.kleanarchitekture.domain.comment.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import javax.inject.Inject

class FetchCommentsByPost @Inject constructor(private val repository: CommentRepository) : UseCase<Int, Single<List<Post>>> {

    override fun execute(param: Int): Single<List<Post>> = repository.fetch(param)
}