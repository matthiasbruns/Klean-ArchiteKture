package com.matthiasbruns.kleanarchitekture.app.feature.user.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.matthiasbruns.kleanarchitekture.app.glide.GlideApp
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationPhoto
import kotlinx.android.synthetic.main.item_user_gallery_photo.view.*

class PhotoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(photo: PresentationPhoto) {
        with(itemView) {
            GlideApp.with(context)
                    .load(photo.url)
                    .thumbnail(GlideApp.with(context).load(photo.thumbnailUrl))
                    .into(image)

            title.text = photo.title
        }
    }
}