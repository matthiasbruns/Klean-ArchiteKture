package com.matthiasbruns.kleanarchitekture.presentation.post.model

data class PresentationPostComment(val id: Int,
                                   val postId: Int,
                                   val name: String,
                                   val email: String,
                                   val body: String)