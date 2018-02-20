package com.matthiasbruns.kleanarchitekture.data.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.GeoEntry
import com.matthiasbruns.kleanarchitekture.domain.user.model.Geo
import javax.inject.Inject

class GeoEntryMapper @Inject constructor() : Mapper<GeoEntry, Geo> {

    override fun map(from: GeoEntry): Geo = with(from) {
        Geo(lat = lat, lng = lng)
    }
}