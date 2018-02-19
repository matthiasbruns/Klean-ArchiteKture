package com.matthiasbruns.kleanarchitekture.domain.post.usecase

import com.matthiasbruns.kleanarchitekture.domain.NoArgUseCase
import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FetchLatestPosts @Inject constructor(private val repository: PostRepository,
                                           private val sortPortByIdDesc: SortPortByIdDesc) : NoArgUseCase<Single<List<Post>>> {

    override fun execute(): Single<List<Post>> = repository.fetch()
            .flatMap { sortPortByIdDesc.execute(it) }
}