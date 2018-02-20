package com.matthiasbruns.kleanarchitekture.data.user

import com.matthiasbruns.kleanarchitekture.commons.rx.RxOptional
import com.matthiasbruns.kleanarchitekture.data.user.mapper.UserEntryMapper
import com.matthiasbruns.kleanarchitekture.domain.user.UserRepository
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import io.reactivex.Maybe
import javax.inject.Inject

class AdvancedDataUserRepository @Inject constructor(private val remote: UserRemote,
                                                     private val local: UserLocal,
                                                     private val mapper: UserEntryMapper) : UserRepository {

    override fun fetch(userId: Int): Maybe<User> =
            // check if local has our user
            local.fetch(userId)
                    .map { RxOptional.ofNullable(it) }
                    .toSingle(RxOptional.empty())
                    .flatMapMaybe {
                        it.value?.let { Maybe.just(it) }
                                ?: remote.fetch(userId).flatMap { local.update(it).toMaybe() }
                    }
                    // Is we loaded a user, go and map it to domain.User
                    .map(mapper::map)
}