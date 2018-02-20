package com.matthiasbruns.kleanarchitekture.remote.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.GeoEntry
import com.matthiasbruns.kleanarchitekture.remote.user.model.RemoteGeo
import javax.inject.Inject

class RemoteGeoMapper @Inject constructor() : Mapper<RemoteGeo, GeoEntry> {

    override fun map(from: RemoteGeo): GeoEntry = with(from) {
        GeoEntry(lat = lat,
                lng = lng)
    }
}