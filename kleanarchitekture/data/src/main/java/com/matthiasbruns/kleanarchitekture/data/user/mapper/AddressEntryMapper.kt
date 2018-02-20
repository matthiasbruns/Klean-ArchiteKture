package com.matthiasbruns.kleanarchitekture.data.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.AddressEntry
import com.matthiasbruns.kleanarchitekture.domain.user.model.Address
import javax.inject.Inject

class AddressEntryMapper @Inject constructor(private val geoMapper: GeoEntryMapper) : Mapper<AddressEntry, Address> {

    override fun map(from: AddressEntry): Address = with(from) {
        Address(street = street,
                city = city,
                suite = suite,
                zipCode = zipCode,
                geo = geoMapper.map(geo))
    }
}