package com.matthiasbruns.kleanarchitekture.presentation.album.model

data class PresentationAlbum(val id: Int,
                             val userId: Int,
                             val title: String,
                             val photos: List<PresentationPhoto>)