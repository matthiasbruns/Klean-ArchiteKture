package com.matthiasbruns.kleanarchitekture.data.photo.model

data class PhotoEntry(val id: Int,
                      val albumId: Int,
                      val title: String,
                      val url: String,
                      val thumbnailUrl: String)