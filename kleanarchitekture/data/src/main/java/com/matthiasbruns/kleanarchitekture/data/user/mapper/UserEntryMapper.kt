package com.matthiasbruns.kleanarchitekture.data.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.UserEntry
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import javax.inject.Inject

class UserEntryMapper @Inject constructor(private val addressMapper: AddressEntryMapper,
                                          private val companyMapper: CompanyEntryMapper) : Mapper<UserEntry, User> {

    override fun map(from: UserEntry): User = with(from) {
        User(id = id,
                name = name,
                email = email,
                username = username,
                phone = phone,
                website = website,
                address = address?.let(addressMapper::map),
                company = company?.let(companyMapper::map)
        )
    }
}