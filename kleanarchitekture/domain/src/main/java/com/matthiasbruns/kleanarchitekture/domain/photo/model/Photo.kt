package com.matthiasbruns.kleanarchitekture.domain.photo.model

data class Photo(val id: Int,
                 val albumId: Int,
                 val title: String,
                 val url: String,
                 val thumbnailUrl: String)