package com.matthiasbruns.kleanarchitekture.local.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.BiDirectionalMapper
import com.matthiasbruns.kleanarchitekture.data.user.model.GeoEntry
import com.matthiasbruns.kleanarchitekture.local.user.model.LocalGeoEntry
import javax.inject.Inject

class LocalGeoEntryMapper @Inject constructor() : BiDirectionalMapper<LocalGeoEntry, GeoEntry> {

    override fun mapFrom(from: GeoEntry): LocalGeoEntry = with(from) {
        LocalGeoEntry(lat = lat,
                lng = lng)
    }

    override fun mapTo(from: LocalGeoEntry): GeoEntry = with(from) {
        GeoEntry(lat = lat,
                lng = lng)
    }
}