package com.matthiasbruns.kleanarchitekture.app.feature.post.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.matthiasbruns.kleanarchitekture.app.R

class PostListController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_post_list, container, false)

        return view
    }
}