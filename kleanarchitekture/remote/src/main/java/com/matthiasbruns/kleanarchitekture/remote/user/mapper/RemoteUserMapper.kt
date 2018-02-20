package com.matthiasbruns.kleanarchitekture.remote.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.remote.user.model.RemoteUser
import javax.inject.Inject

class RemoteUserMapper @Inject constructor(private val addressMapper: RemoteAddressMapper,
                                           private val companyMapper: RemoteCompanyMapper) : Mapper<RemoteUser, UserEntry> {

    override fun map(from: RemoteUser): UserEntry = with(from) {
        UserEntry(id = id,
                name = name,
                username = username,
                email = email,
                phone = phone,
                website = website,
                address = address?.let(addressMapper::map),
                company = company?.let(companyMapper::map)
        )
    }
}