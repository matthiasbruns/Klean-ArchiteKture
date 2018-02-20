package com.matthiasbruns.kleanarchitekture.data.photo

import com.matthiasbruns.kleanarchitekture.data.photo.model.PhotoEntry
import io.reactivex.Maybe
import io.reactivex.Single

interface PhotoRemote {

    fun fetch(): Single<List<PhotoEntry>>

    fun fetch(id: Int): Maybe<PhotoEntry>

    fun fetchByAlbum(albumId: Int): Single<List<PhotoEntry>>
}