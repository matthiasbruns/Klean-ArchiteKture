package com.matthiasbruns.kleanarchitekture.remote.photo.model;

import com.squareup.moshi.Json

data class RemotePhoto(@Json(name = "id") val id: Int,
                       @Json(name = "albumId") val albumId: Int,
                       @Json(name = "title") val title: String,
                       @Json(name = "url") val url: String,
                       @Json(name = "thumbnailUrl") val thumbnailUrl: String)