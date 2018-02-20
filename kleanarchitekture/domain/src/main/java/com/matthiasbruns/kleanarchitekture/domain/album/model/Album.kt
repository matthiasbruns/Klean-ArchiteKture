package com.matthiasbruns.kleanarchitekture.domain.album.model

data class Album(val id: Int,
                 val userId: Int,
                 val title: String,
                 val photos: List<Photo>)