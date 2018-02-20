package com.matthiasbruns.kleanarchitekture.domain.photo

import com.matthiasbruns.kleanarchitekture.domain.photo.model.Photo
import io.reactivex.Maybe
import io.reactivex.Single

interface PhotoRepository {

    fun fetch(): Single<List<Photo>>

    fun fetch(id: Int): Maybe<Photo>

    fun fetchByAlbum(albumId: Int): Single<List<Photo>>
}