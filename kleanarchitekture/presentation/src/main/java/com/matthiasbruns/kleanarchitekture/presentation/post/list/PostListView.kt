package com.matthiasbruns.kleanarchitekture.presentation.post.list

import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import io.reactivex.Observable

interface PostListView {

    val onPostClick: Observable<Int>

    fun render(it: List<PresentationPostItem>)
}