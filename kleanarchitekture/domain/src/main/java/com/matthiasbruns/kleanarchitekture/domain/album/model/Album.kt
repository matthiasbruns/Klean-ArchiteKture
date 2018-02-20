package com.matthiasbruns.kleanarchitekture.domain.album.model

import com.matthiasbruns.kleanarchitekture.domain.photo.model.Photo

data class Album(val id: Int,
                 val userId: Int,
                 val title: String,
                 val photos: List<Photo>)