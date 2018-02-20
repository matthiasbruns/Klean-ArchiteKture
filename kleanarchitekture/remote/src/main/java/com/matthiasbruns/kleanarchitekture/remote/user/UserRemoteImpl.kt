package com.matthiasbruns.kleanarchitekture.remote.user

import com.matthiasbruns.kleanarchitekture.data.user.UserRemote
import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.remote.ApiError
import com.matthiasbruns.kleanarchitekture.remote.user.mapper.RemoteUserMapper
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRemoteImpl @Inject constructor(private val api: UserApi,
                                         private val mapper: RemoteUserMapper) : UserRemote {

    override fun fetch(userId: Int): Maybe<UserEntry> = api.fetch(userId)
            .subscribeOn(Schedulers.io())
            .toMaybe()
            .map { ApiError.handleResult(it) }
            .map(mapper::map)
}