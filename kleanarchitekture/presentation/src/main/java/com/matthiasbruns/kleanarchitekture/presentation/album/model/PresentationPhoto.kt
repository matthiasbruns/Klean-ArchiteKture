package com.matthiasbruns.kleanarchitekture.presentation.album.model

data class PresentationPhoto(val id: Int,
                             val albumId: Int,
                             val title: String,
                             val url: String,
                             val thumbnailUrl: String)