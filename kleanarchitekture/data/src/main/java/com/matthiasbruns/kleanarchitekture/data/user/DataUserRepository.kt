package com.matthiasbruns.kleanarchitekture.data.user

import com.matthiasbruns.kleanarchitekture.data.user.mapper.UserEntryMapper
import com.matthiasbruns.kleanarchitekture.domain.user.UserRepository
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import io.reactivex.Maybe
import javax.inject.Inject

class DataUserRepository @Inject constructor(private val remote: UserRemote,
                                             private val mapper: UserEntryMapper) : UserRepository {

    override fun fetch(userId: Int): Maybe<User> = remote.fetch(userId).map(mapper::map)
}