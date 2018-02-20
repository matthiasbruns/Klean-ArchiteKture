package com.matthiasbruns.kleanarchitekture.domain.album.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.album.AlbumRepository
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import io.reactivex.Maybe
import javax.inject.Inject

class FetchLatestAlbumByUserId @Inject constructor(private val repository: AlbumRepository) : UseCase<Int, Maybe<Album>> {

    override fun execute(param: Int): Maybe<Album> = repository.fetchByUser(param, 1, true)
            .toMaybe()
            .map { if (it.isNotEmpty()) it.first() else null }
}