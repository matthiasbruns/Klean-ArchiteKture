package com.matthiasbruns.kleanarchitekture.local.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.BiDirectionalMapper
import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.local.user.model.LocalUserEntry
import javax.inject.Inject

class LocalUserEntryMapper @Inject constructor(private val addressMapper: LocalAddressEntryMapper,
                                               private val companyMapper: LocalCompanyEntryMapper) : BiDirectionalMapper<LocalUserEntry, UserEntry> {

    override fun mapFrom(from: UserEntry): LocalUserEntry = with(from) {
        LocalUserEntry(id = id,
                username = username,
                phone = phone,
                email = email,
                name = name,
                website = website,
                address = address?.let(addressMapper::mapFrom),
                company = company?.let(companyMapper::mapFrom)
        )
    }

    override fun mapTo(from: LocalUserEntry): UserEntry = with(from) {
        UserEntry(id = id,
                username = username,
                phone = phone,
                email = email,
                name = name,
                website = website,
                address = address?.let(addressMapper::mapTo),
                company = company?.let(companyMapper::mapTo)
        )
    }
}