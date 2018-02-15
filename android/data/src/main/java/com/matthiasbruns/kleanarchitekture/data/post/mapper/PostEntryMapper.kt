package com.matthiasbruns.kleanarchitekture.data.post.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.post.model.PostEntry
import com.matthiasbruns.kleanarchitekture.domain.post.model.Post
import javax.inject.Inject

class PostEntryMapper @Inject constructor() : Mapper<PostEntry, Post> {

    override fun map(from: PostEntry): Post = with(from) {
        Post(id = id,
                userId = userId,
                title = title,
                body = body)
    }
}