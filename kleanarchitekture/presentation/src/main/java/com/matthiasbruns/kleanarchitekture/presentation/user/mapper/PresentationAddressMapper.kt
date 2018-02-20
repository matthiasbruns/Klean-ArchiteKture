package com.matthiasbruns.kleanarchitekture.presentation.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.user.model.Address
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationAddress
import javax.inject.Inject

interface PresentationAddressValueFormatter {
    fun formatAddress(street: String, city: String, suite: String, zipCode: String): String
}

class PresentationAddressMapper @Inject constructor(private val valueFormatter: PresentationAddressValueFormatter,
                                                    private val geoMapper: PresentationGeoMapper) : Mapper<Address, PresentationAddress> {

    override fun map(from: Address): PresentationAddress = with(from) {
        PresentationAddress(street = street,
                city = city,
                suite = suite,
                zipCode = zipCode,
                formattedAddress = valueFormatter.formatAddress(street = street, zipCode = zipCode, suite = suite, city = city),
                geo = geoMapper.map(geo))
    }
}