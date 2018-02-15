package com.matthiasbruns.kleanarchitekture.remote.user.model

import com.squareup.moshi.Json

data class RemoteAddress(@Json(name = "street") val street: String,
                         @Json(name = "suite") val suite: String,
                         @Json(name = "city") val city: String,
                         @Json(name = "zipcode") val zipCode: String,
                         @Json(name = "geo") val geo: RemoteGeo)