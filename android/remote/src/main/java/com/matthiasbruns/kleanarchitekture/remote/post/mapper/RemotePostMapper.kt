package com.matthiasbruns.kleanarchitekture.remote.post.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.post.model.PostEntry
import com.matthiasbruns.kleanarchitekture.remote.post.model.RemotePost
import javax.inject.Inject

class RemotePostMapper @Inject constructor() : Mapper<RemotePost, PostEntry> {

    override fun map(from: RemotePost): PostEntry = with(from) {
        PostEntry(id = id,
                userId = userId,
                title = title,
                body = body)
    }
}