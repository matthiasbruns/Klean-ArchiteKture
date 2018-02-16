package com.matthiasbruns.kleanarchitekture.remote.user.model

import com.squareup.moshi.Json

data class RemoteGeo(@Json(name = "lat") val lat: String,
                     @Json(name = "lng") val lng: String)