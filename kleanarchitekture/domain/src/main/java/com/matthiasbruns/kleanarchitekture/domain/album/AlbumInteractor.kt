package com.matthiasbruns.kleanarchitekture.domain.album

import com.matthiasbruns.kleanarchitekture.domain.album.usecase.FetchAlbumsByUserId
import com.matthiasbruns.kleanarchitekture.domain.album.usecase.FetchLatestAlbumByUserId
import javax.inject.Inject

class AlbumInteractor @Inject constructor(val fetchAlbumsByUserId: FetchAlbumsByUserId,
                                          val fetchLatestAlbumByUserId: FetchLatestAlbumByUserId)