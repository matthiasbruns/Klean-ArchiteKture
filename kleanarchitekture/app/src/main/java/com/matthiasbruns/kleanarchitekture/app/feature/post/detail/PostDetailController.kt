package com.matthiasbruns.kleanarchitekture.app.feature.post.detail

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.MainActivity
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.controller.PresenterController
import com.matthiasbruns.kleanarchitekture.app.feature.post.detail.adapter.PostCommentsAdapter
import com.matthiasbruns.kleanarchitekture.app.feature.post.mapper.ParcelablePresentationPostItemMapper
import com.matthiasbruns.kleanarchitekture.app.feature.post.model.ParcelablePresentationPost
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.PostDetailView
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.presenter.PostDetailPresenter
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import kotlinx.android.synthetic.main.controller_post_detail.view.*
import javax.inject.Inject

class PostDetailController(bundle: Bundle) : PresenterController<PostDetailPresenter>(bundle), PostDetailView {

    companion object {

        private const val EXTRA_POST = "EXTRA_POST"

        fun create(post: ParcelablePresentationPost): PostDetailController =
                Bundle().apply { putParcelable(EXTRA_POST, post) }
                        .let { PostDetailController(it) }
    }

    //region Members

    private val adapter by lazy { PostCommentsAdapter() }

    //endregion

    //region Injects

    @Inject
    override lateinit var presenter: PostDetailPresenter

    @Inject
    lateinit var mapper: ParcelablePresentationPostItemMapper

    //endregion

    //region PostDetailView method implementations

    override val post: PresentationPost by lazy { mapper.mapFrom(args.getParcelable(EXTRA_POST)) }

    //endregion

    //region PostDetailView method implementations

    override fun injectDependencies(context: Context) {
        MainActivity.instance(context)
                ?.postComponent
                ?.plus(PostDetailModule(this))
                ?.inject(this)
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_post_detail, container, false)

        with(view) {
            postComments.adapter = adapter
            postComments.setHasFixedSize(true)
            postComments.layoutManager = LinearLayoutManager(context)
            postComments.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        return view
    }

    override fun setPost(post: PresentationPost) {
        view?.apply {
            postTitle.text = post.title
            postBody.text = post.body
        }
    }

    override fun setComments(comments: List<PresentationPostComment>) {
        adapter.items = comments
    }

    //endregion
}