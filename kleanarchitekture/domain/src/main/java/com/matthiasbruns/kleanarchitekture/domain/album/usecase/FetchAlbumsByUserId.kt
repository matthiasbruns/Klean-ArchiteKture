package com.matthiasbruns.kleanarchitekture.domain.album.usecase

import com.matthiasbruns.kleanarchitekture.domain.UseCase
import com.matthiasbruns.kleanarchitekture.domain.album.AlbumRepository
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import io.reactivex.Single
import javax.inject.Inject

class FetchAlbumsByUserId @Inject constructor(private val repository: AlbumRepository) : UseCase<Int, Single<List<Album>>> {

    override fun execute(param: Int): Single<List<Album>> = repository.fetchByUser(param)
}