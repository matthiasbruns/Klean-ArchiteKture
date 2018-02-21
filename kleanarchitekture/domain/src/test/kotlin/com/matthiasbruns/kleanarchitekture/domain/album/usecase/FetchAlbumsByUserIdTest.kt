package com.matthiasbruns.kleanarchitekture.domain.album.usecase

import com.matthiasbruns.kleanarchitekture.domain.album.AlbumRepository
import com.matthiasbruns.kleanarchitekture.domain.album.model.Album
import com.nhaarman.mockito_kotlin.any
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

                whenever(repository.fetchByUser(any())).thenReturn(Single.just(albumList))

                useCase.execute(1).test()
                        .assertValue { albumList === albumList }
                        .assertComplete()
            }

        }

    }
}