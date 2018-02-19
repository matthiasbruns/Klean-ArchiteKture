package com.matthiasbruns.kleanarchitekture.app.feature.post.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.matthiasbruns.kleanarchitekture.presentation.post.model.PresentationPostComment
import kotlinx.android.synthetic.main.item_post_comment.view.*

class PostCommentViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bind(comment: PresentationPostComment) {
        with(itemView) {
            postCommentAuthor.text = comment.name
            postCommentBody.text = comment.body
//            postCommentEmail.text = comment.email
            postCommentEmail.text = comment.maskedEmail
        }
    }
}