package com.matthiasbruns.kleanarchitekture.presentation.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.user.model.Geo
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationGeo
import javax.inject.Inject

class PresentationGeoMapper @Inject constructor() : Mapper<Geo, PresentationGeo> {

    override fun map(from: Geo): PresentationGeo = with(from) {
        PresentationGeo(lat = lat, lng = lng)
    }
}