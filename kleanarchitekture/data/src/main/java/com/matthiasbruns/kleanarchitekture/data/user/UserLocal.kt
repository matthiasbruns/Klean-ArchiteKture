package com.matthiasbruns.kleanarchitekture.data.user

import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface UserLocal {

    fun fetch(userId: Int): Maybe<UserEntry>

    fun update(user: UserEntry): Single<UserEntry>

    fun remove(userId: Int): Completable

    fun removeAll(): Completable
}