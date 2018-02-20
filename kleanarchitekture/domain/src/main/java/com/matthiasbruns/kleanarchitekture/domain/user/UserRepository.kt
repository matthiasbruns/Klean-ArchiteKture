package com.matthiasbruns.kleanarchitekture.domain.user

import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import io.reactivex.Maybe

interface UserRepository {

    fun fetch(userId: Int): Maybe<User>
}