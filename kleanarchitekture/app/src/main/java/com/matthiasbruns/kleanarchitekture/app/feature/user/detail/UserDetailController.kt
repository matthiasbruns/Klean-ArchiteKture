package com.matthiasbruns.kleanarchitekture.app.feature.user.detail

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.matthiasbruns.kleanarchitekture.app.MainActivity
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.controller.PresenterController
import com.matthiasbruns.kleanarchitekture.app.feature.user.detail.adapter.PhotoAdaper
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationAlbum
import com.matthiasbruns.kleanarchitekture.presentation.user.detail.UserDetailView
import com.matthiasbruns.kleanarchitekture.presentation.user.detail.presenter.UserDetailPresenter
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationUser
import kotlinx.android.synthetic.main.controller_user_detail.view.*
import javax.inject.Inject

class UserDetailController(bundle: Bundle) : PresenterController<UserDetailPresenter>(bundle), UserDetailView {

    companion object {
        const val EXTRA_USER_ID = "EXTRA_USER_ID"

        fun create(userId: Int) = Bundle()
                .apply { putInt(EXTRA_USER_ID, userId) }
                .let { UserDetailController(it) }
    }

    private val adapter by lazy { PhotoAdaper() }

    override val userId: Int by lazy { args.getInt(EXTRA_USER_ID) }


    //region Injects

    @Inject
    override lateinit var presenter: UserDetailPresenter

    //endregion

    override fun injectDependencies(context: Context) {
        MainActivity.instance(context)
                ?.userComponent
                ?.plus(UserDetailModule(this))
                ?.inject(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_user_detail, container, false)

        with(view) {
            userGalleryRecyclerView.adapter = adapter
            userGalleryRecyclerView.setHasFixedSize(true)
            userGalleryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        return view
    }

    //region UserDetailView method implementations

    override fun setUser(user: PresentationUser) {
        view?.apply {
            userName.text = user.formattedName
            userEmail.text = user.email

            user.phone?.let {
                userPhone.visibility = View.VISIBLE
                userPhoneLabel.visibility = View.VISIBLE
                userPhone.text = it
            } ?: run {
                userPhone.visibility = View.GONE
                userPhoneLabel.visibility = View.GONE
            }

            user.website?.let {
                userWebsite.visibility = View.VISIBLE
                userWebsiteLabel.visibility = View.VISIBLE
                userWebsite.text = it
            } ?: run {
                userWebsite.visibility = View.GONE
                userWebsiteLabel.visibility = View.GONE
            }

            user.address?.let {
                userAddress.visibility = View.VISIBLE
                userAddressLabel.visibility = View.VISIBLE
                userAddress.text = it.formattedAddress
            } ?: run {
                userAddress.visibility = View.GONE
                userAddressLabel.visibility = View.GONE
            }

            user.company?.let {
                userCompanyCard.visibility = View.VISIBLE
                userCompany.text = it.formattedCompany
            } ?: run { userCompanyCard.visibility = View.GONE }
        }
    }

    override fun hideError() {

    }

    override fun showError(throwable: Throwable) {
        activity?.let { context ->
            Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun setGallery(album: PresentationAlbum) {
        adapter.items = album.photos
    }

    //endregion
}