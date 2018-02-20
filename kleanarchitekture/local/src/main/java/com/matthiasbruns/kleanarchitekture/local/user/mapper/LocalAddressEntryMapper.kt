package com.matthiasbruns.kleanarchitekture.local.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.BiDirectionalMapper
import com.matthiasbruns.kleanarchitekture.data.user.model.AddressEntry
import com.matthiasbruns.kleanarchitekture.local.user.model.LocalAddressEntry
import javax.inject.Inject

class LocalAddressEntryMapper @Inject constructor(private val geoMapper: LocalGeoEntryMapper) : BiDirectionalMapper<LocalAddressEntry, AddressEntry> {

    override fun mapFrom(from: AddressEntry): LocalAddressEntry = with(from) {
        LocalAddressEntry(street = street,
                zipCode = zipCode,
                suite = suite,
                city = city,
                geo = geoMapper.mapFrom(geo))

    }

    override fun mapTo(from: LocalAddressEntry): AddressEntry = with(from) {
        AddressEntry(street = street,
                zipCode = zipCode,
                suite = suite,
                city = city,
                geo = geoMapper.mapTo(geo))

    }
}