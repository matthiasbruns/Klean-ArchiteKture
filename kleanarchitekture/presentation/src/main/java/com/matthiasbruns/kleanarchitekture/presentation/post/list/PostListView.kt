package com.matthiasbruns.kleanarchitekture.presentation.post.list

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import io.reactivex.Observable

interface PostListView {

    val onPostClick: Observable<PresentationPostItem>

    val onRequestRefresh: Observable<Any>

    fun render(items: List<PresentationPostItem>)

    fun showError()

    fun hideError()

    fun setLoading(show: Boolean)
}