package com.matthiasbruns.kleanarchitekture.app.feature.post.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.KleanApp
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.controller.PresenterController
import com.matthiasbruns.kleanarchitekture.app.feature.post.list.adapter.PostListAdapter
import com.matthiasbruns.kleanarchitekture.presentation.post.list.PostListView
import com.matthiasbruns.kleanarchitekture.presentation.post.list.presenter.PostListPresenter
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import io.reactivex.Observable
import kotlinx.android.synthetic.main.controller_post_list.view.*
import javax.inject.Inject

class PostListController : PresenterController<PostListPresenter>(), PostListView {

    //region Members

    private val adapter by lazy { PostListAdapter() }

    //endregion

    //region Injects

    @Inject
    override lateinit var presenter: PostListPresenter

    //endregion

    //region PostListView member implementations

    override val onPostClick: Observable<PresentationPostItem>
        get() = adapter.onItemClick

    //endregion

    override fun injectDependencies(context: Context) {
        KleanApp.instance(context)
                ?.postComponent
                ?.plus(PostListModule(this))
                ?.inject(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_post_list, container, false)

        view.postListRecyclerView.adapter = adapter

        return view
    }

    //region View method implementations

    override fun render(items: List<PresentationPostItem>) {
        adapter.items = items
    }

    //endregion
}