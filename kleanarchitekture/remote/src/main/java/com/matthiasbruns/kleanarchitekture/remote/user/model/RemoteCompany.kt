package com.matthiasbruns.kleanarchitekture.remote.user.model

import com.squareup.moshi.Json

data class RemoteCompany(@Json(name = "name") val name: String,
                         @Json(name = "catchPhrase") val catchPhrase: String,
                         @Json(name = "bs") val bs: String)