package com.matthiasbruns.kleanarchitekture.remote.post.model

import com.squareup.moshi.Json

data class RemotePost(@Json(name = "id") val id: Int,
                      @Json(name = "userId") val userId: Int,
                      @Json(name = "title") val title: String,
                      @Json(name = "body") val body: String
)