package com.matthiasbruns.kleanarchitekture.app.feature.post.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.adapter.AutoUpdatableAdapter
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostItem
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlin.properties.Delegates

class PostListAdapter : RecyclerView.Adapter<PostListViewHolder>(), AutoUpdatableAdapter {

    /**
     * https://antonioleiva.com/recyclerview-diffutil-kotlin
     */
    var items: List<PresentationPostItem> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }

    private val _onItemClick: Subject<PresentationPostItem> by lazy { PublishSubject.create<PresentationPostItem>() }
    val onItemClick: Observable<PresentationPostItem>
        get() = _onItemClick

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostListViewHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
        holder?.itemView?.setOnClickListener { _onItemClick.onNext(item) }
    }
}