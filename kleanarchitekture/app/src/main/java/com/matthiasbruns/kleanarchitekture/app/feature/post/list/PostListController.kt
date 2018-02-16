package com.matthiasbruns.kleanarchitekture.app.feature.post.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.PresenterController
import com.matthiasbruns.kleanarchitekture.presentation.post.list.presenter.PostListPresenter
import javax.inject.Inject

class PostListController : PresenterController<PostListPresenter>() {

    @Inject
    override lateinit var presenter: PostListPresenter

    override fun injectDependencies(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_post_list, container, false)

        return view
    }
}