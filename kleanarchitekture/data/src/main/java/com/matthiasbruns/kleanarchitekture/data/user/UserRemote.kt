package com.matthiasbruns.kleanarchitekture.data.user

import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import io.reactivex.Maybe

interface UserRemote {

    fun fetch(userId: Int): Maybe<UserEntry>
}