package com.matthiasbruns.kleanarchitekture.presentation.user.detail

import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationAlbum
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationUser

interface UserDetailView {

    val userId: Int

    fun setUser(user: PresentationUser)

    fun setGallery(album: PresentationAlbum)

    fun hideError()

    fun showError(throwable: Throwable)
}