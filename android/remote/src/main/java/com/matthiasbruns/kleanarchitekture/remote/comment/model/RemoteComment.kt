package com.matthiasbruns.kleanarchitekture.remote.comment.model

import com.squareup.moshi.Json

data class RemoteComment(@Json(name = "id") val id: Int,
                         @Json(name = "postId") val postId: Int,
                         @Json(name = "name") val name: String,
                         @Json(name = "email") val email: String,
                         @Json(name = "body") val body: String)