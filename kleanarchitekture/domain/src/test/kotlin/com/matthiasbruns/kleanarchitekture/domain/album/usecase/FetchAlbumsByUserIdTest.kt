package com.matthiasbruns.kleanarchitekture.domain.album.usecase

import com.matthiasbruns.kleanarchitekture.domain.album.AlbumRepository
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.kotlintest.specs.WordSpec
import io.reactivex.Single

/**
 * Test for [FetchAlbumsByUserId]
 */
class FetchAlbumsByUserIdTest : WordSpec() {

    private val repositoryMock: AlbumRepository
        get() = mock()

    init {
        "FetchAlbumsByUserId.execute" should {

            "return the same object as the one returned from the AlbumRepository "{
                val repository = repositoryMock
                val useCase = FetchAlbumsByUserId(repository)
                val albumList = listOf<Album>()

                whenever(repository.fetchByUser(1)).thenReturn(Single.just(albumList))
                val element = Album(id = 1, userId = 1, photos = emptyList(), title = "GOOD ALBUM")
                whenever(repository.fetchByUser(2)).thenReturn(Single.just(listOf(element)))

                useCase.execute(1).test()
                        .assertValue { it === albumList }
                        .assertComplete()

                useCase.execute(2).test()
                        .assertValue { it.size == 1 }
                        .assertValue { it.first() === element }
                        .assertComplete()

            }
        }
    }
}