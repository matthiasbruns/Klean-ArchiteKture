package com.matthiasbruns.kleanarchitekture.presentation.post.list

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import io.reactivex.Observable

interface PostListView {

    val onPostClick: Observable<PresentationPost>

    val onRequestRefresh: Observable<Any>

    fun render(items: List<PresentationPost>)

    fun showError()

    fun hideError()

    fun setLoading(show: Boolean)
}