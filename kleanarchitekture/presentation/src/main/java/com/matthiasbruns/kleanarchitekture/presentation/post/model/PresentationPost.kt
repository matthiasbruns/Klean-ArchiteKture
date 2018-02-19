package com.matthiasbruns.kleanarchitekture.presentation.post.model

data class PresentationPost(val id: Int,
                            val userId: Int,
                            val title: String,
                            val body: String)