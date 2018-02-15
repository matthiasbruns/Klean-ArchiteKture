package com.matthiasbruns.kleanarchitekture.presentation.post.model

data class PresentationPostItem(val id: Int,
                                val userId: Int,
                                val title: String,
                                val body: String)