package com.matthiasbruns.kleanarchitekture.app.feature.user.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.adapter.AutoUpdatableAdapter
import com.matthiasbruns.kleanarchitekture.presentation.album.model.PresentationPhoto
import kotlin.properties.Delegates

class PhotoAdaper : RecyclerView.Adapter<PhotoViewHolder>(), AutoUpdatableAdapter {

    /**
     * https://antonioleiva.com/recyclerview-diffutil-kotlin
     */
    var items: List<PresentationPhoto> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_gallery_photo, parent, false)
        return PhotoViewHolder(view)
    }
}