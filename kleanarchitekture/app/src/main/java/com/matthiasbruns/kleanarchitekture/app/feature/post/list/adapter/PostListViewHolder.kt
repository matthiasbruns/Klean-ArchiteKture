package com.matthiasbruns.kleanarchitekture.app.feature.post.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPost
import kotlinx.android.synthetic.main.item_post.view.*

class PostListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: PresentationPost) {
        itemView.postTitle.text = item.title
        itemView.postBody.text = item.body
    }
}