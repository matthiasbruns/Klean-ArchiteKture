package com.matthiasbruns.kleanarchitekture.local.cache

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.Single

class RxCache<T, in ID>(private val cache: Cache<T, ID>) {

    fun get(id: ID): Maybe<T> = Maybe.create { emitter: MaybeEmitter<T> ->
        cache.get(id)?.let { emitter.onSuccess(it) }
        emitter.onComplete()
    }

    fun update(item: T): Single<T> = Single.fromCallable {
        cache.update(item)
        item
    }

    fun remove(id: ID): Completable = Completable.fromCallable { cache.remove(id) }

    fun invalidate(): Completable = Completable.fromCallable { cache.invalidate() }
}