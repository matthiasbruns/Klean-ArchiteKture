package com.matthiasbruns.kleanarchitekture.domain.user

import com.matthiasbruns.kleanarchitekture.domain.user.usecase.FetchUserById
import javax.inject.Inject

class UserInteractor @Inject constructor(val fetchUserById: FetchUserById)