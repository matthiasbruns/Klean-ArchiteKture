package com.matthiasbruns.kleanarchitekture.domain.user.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.user.UserRepository
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import io.reactivex.Maybe
import javax.inject.Inject

class FetchUserById @Inject constructor(private val repository: UserRepository) : UseCase<Int, Maybe<User>> {

    override fun execute(param: Int): Maybe<User> = repository.fetch(param)
}