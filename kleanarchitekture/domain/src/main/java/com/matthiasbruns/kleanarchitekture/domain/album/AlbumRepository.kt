package com.matthiasbruns.kleanarchitekture.domain.album

import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import io.reactivex.Maybe
import io.reactivex.Single

interface AlbumRepository {

    fun fetch(id: Int): Maybe<Album>

    fun fetchByUser(userId: Int, desc: Boolean = true): Single<List<Album>>

    fun fetchByUser(userId: Int, max: Int, desc: Boolean = true): Single<List<Album>>
}