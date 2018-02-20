package com.matthiasbruns.kleanarchitekture.local.user

import com.matthiasbruns.kleanarchitekture.local.cache.ExpiringCache
import com.matthiasbruns.kleanarchitekture.local.user.model.LocalUserEntry
import javax.inject.Inject

class UserExpiringCache @Inject constructor(): ExpiringCache<LocalUserEntry, Int>() {

    override fun getId(item: LocalUserEntry): Int = item.id
}