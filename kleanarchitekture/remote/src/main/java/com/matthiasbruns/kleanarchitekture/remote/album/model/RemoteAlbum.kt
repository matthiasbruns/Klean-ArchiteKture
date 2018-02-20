package com.matthiasbruns.kleanarchitekture.remote.album.model

import com.squareup.moshi.Json

data class RemoteAlbum(@Json(name = "id") val id: Int,
                       @Json(name = "userId") val userId: Int,
                       @Json(name = "title") val title: String)