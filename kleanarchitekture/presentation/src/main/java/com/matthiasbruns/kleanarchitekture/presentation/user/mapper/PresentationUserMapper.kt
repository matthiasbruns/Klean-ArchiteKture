package com.matthiasbruns.kleanarchitekture.presentation.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.user.model.User
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationUser
import javax.inject.Inject

interface PresentationUserValueFormatter {
    fun formatName(username: String, name: String?): String
}

class PresentationUserMapper @Inject constructor(private val valueFormatter: PresentationUserValueFormatter,
                                                 private val addressMapper: PresentationAddressMapper,
                                                 private val companyMapper: PresentationCompanyMapper) : Mapper<User, PresentationUser> {

    override fun map(from: User): PresentationUser = with(from) {
        PresentationUser(id = id,
                name = name,
                email = email,
                username = username,
                phone = phone,
                website = website?.let {
                    when (it.toLowerCase().contains("http")) {
                        true -> it
                        else -> "http://$it"
                    }
                },
                address = address?.let(addressMapper::map),
                company = company?.let(companyMapper::map),
                formattedName = valueFormatter.formatName(username, name)
        )
    }
}