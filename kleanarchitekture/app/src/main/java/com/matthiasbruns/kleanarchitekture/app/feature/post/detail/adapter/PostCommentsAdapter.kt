package com.matthiasbruns.kleanarchitekture.app.feature.post.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.base.adapter.AutoUpdatableAdapter
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlin.properties.Delegates

class PostCommentsAdapter : RecyclerView.Adapter<PostCommentViewHolder>(), AutoUpdatableAdapter {

    /**
     * https://antonioleiva.com/recyclerview-diffutil-kotlin
     */
    var items: List<PresentationPostComment> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }

    private val _onItemClick: Subject<PresentationPostComment> by lazy { PublishSubject.create<PresentationPostComment>() }
    val onItemClick: Observable<PresentationPostComment>
        get() = _onItemClick

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_comment, parent, false)
        return PostCommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostCommentViewHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
        holder?.itemView?.setOnClickListener { _onItemClick.onNext(item) }
    }
}