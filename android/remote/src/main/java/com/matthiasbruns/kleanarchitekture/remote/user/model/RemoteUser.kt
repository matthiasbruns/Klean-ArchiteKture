package com.matthiasbruns.kleanarchitekture.remote.user.model

import com.squareup.moshi.Json

data class RemoteUser(@Json(name = "id") val id: Int,
                      @Json(name = "username") val username: String,
                      @Json(name = "name") val name: String?,
                      @Json(name = "email") val email: String,
                      @Json(name = "phone") val phone: String?,
                      @Json(name = "website") val website: String?,
                      @Json(name = "address") val address: RemoteAddress?,
                      @Json(name = "company") val company: RemoteCompany?
)