package com.matthiasbruns.kleanarchitekture.local.user

import com.matthiasbruns.kleanarchitekture.data.user.UserLocal
import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.local.cache.RxCache
import com.matthiasbruns.kleanarchitekture.local.user.mapper.LocalUserEntryMapper
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class UserLocalImpl @Inject constructor(cache: UserExpiringCache,
                                        private val mapper: LocalUserEntryMapper) : UserLocal {

    private val rxCache = RxCache(cache)

    override fun fetch(userId: Int): Maybe<UserEntry> = rxCache.get(userId).map(mapper::mapTo)

    override fun update(user: UserEntry): Single<UserEntry> = rxCache.update(mapper.mapFrom(user)).map(mapper::mapTo)

    override fun remove(userId: Int): Completable = rxCache.remove(userId)

    override fun removeAll(): Completable = rxCache.invalidate()
}