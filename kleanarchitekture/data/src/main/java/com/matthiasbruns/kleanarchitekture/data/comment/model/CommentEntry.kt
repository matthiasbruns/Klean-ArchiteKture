package com.matthiasbruns.kleanarchitekture.data.comment.model

data class CommentEntry (val id: Int,
                         val postId: Int,
                         val name: String,
                         val email: String,
                         val body: String)