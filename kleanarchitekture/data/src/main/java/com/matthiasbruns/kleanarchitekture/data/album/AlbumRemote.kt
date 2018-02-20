package com.matthiasbruns.kleanarchitekture.data.album

import com.matthiasbruns.kleanarchitekture.data.album.model.AlbumEntry
import io.reactivex.Maybe
import io.reactivex.Single

interface AlbumRemote {

    fun fetch(): Single<List<AlbumEntry>>

    fun fetch(id: Int): Maybe<AlbumEntry>

    fun fetchByUser(userId: Int): Single<List<AlbumEntry>>
}