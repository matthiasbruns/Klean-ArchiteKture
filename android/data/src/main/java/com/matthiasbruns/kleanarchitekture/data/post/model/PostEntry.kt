package com.matthiasbruns.kleanarchitekture.data.post.model

data class PostEntry (val id: Int,
                      val userId: Int,
                      val title: String,
                      val body: String)