package com.matthiasbruns.kleanarchitekture.presentation.user.detail.presenter

import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.matthiasbruns.kleanarchitekture.domain.album.AlbumInteractor
import com.matthiasbruns.kleanarchitekture.domain.user.UserInteractor
import com.matthiasbruns.kleanarchitekture.presentation.DisposablePresenter
import com.matthiasbruns.kleanarchitekture.presentation.Presenter
import com.matthiasbruns.kleanarchitekture.presentation.album.mapper.PresentationAlbumMapper
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationAlbum
import com.matthiasbruns.kleanarchitekture.presentation.user.detail.UserDetailView
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationUserMapper
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationUser
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

interface UserDetailPresenter : Presenter

class UserDetailPresenterImpl @Inject constructor(private val view: UserDetailView,
                                                  private val uiScheduler: Scheduler,
                                                  private val userInteractor: UserInteractor,
                                                  private val albumInteractor: AlbumInteractor,
                                                  private val logger: Logger,
                                                  private val userMapper: PresentationUserMapper,
                                                  private val albumMapper: PresentationAlbumMapper) : DisposablePresenter(), UserDetailPresenter {

    private val user: Single<PresentationUser>
        get() = userInteractor.fetchUserById.execute(view.userId)
                .map(userMapper::map)
                .toSingle()

    private val albums: Single<PresentationAlbum>
        get() = albumInteractor.fetchLatestAlbumByUserId.execute(view.userId)
                .map(albumMapper::map)
                .toSingle()

    override fun onStart() {
        super<DisposablePresenter>.onStart()

        user.observeOn(uiScheduler).subscribeBy(onSuccess = this::handleUserSuccess, onError = this::handleUserError)
        albums.observeOn(uiScheduler).subscribeBy(onSuccess = this::handleAlbumSuccess, onError = this::handleAlbumError)
    }

    private fun handleUserSuccess(user: PresentationUser) {
        view.hideError()
        view.setUser(user)
    }

    private fun handleUserError(throwable: Throwable) {
        view.showError(throwable)
    }

    private fun handleAlbumSuccess(album: PresentationAlbum) {
        view.hideError()
        view.setGallery(album)
    }

    private fun handleAlbumError(throwable: Throwable) {
        view.showError(throwable)
    }

}