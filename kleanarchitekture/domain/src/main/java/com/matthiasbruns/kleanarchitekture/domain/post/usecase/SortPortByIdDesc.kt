package com.matthiasbruns.kleanarchitekture.domain.post.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SortPortByIdDesc @Inject constructor(): UseCase<List<Post>, Single<List<Post>>> {

    override fun execute(param: List<Post>): Single<List<Post>> =
            Observable.fromIterable(param)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.computation())
                    .sorted { o1, o2 -> o2.id - o1.id } // DESC by id - latest first
                    .toList()
}