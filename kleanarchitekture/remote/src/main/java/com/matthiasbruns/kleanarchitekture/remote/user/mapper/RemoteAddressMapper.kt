package com.matthiasbruns.kleanarchitekture.remote.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.AddressEntry
import com.matthiasbruns.kleanarchitekture.remote.user.model.RemoteAddress
import javax.inject.Inject

class RemoteAddressMapper @Inject constructor(private val geoMapper: RemoteGeoMapper) : Mapper<RemoteAddress, AddressEntry> {

    override fun map(from: RemoteAddress): AddressEntry = with(from) {
        AddressEntry(street = street,
                city = city,
                suite = suite,
                zipCode = zipCode,
                geo = geoMapper.map(geo))
    }
}