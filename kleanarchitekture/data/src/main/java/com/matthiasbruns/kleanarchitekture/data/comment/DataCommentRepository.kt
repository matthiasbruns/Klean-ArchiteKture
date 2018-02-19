package com.matthiasbruns.kleanarchitekture.data.comment

import com.matthiasbruns.kleanarchitekture.data.comment.mapper.CommentEntryMapper
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.domain.comment.model.Comment
import io.reactivex.Single
import javax.inject.Inject

class DataCommentRepository @Inject constructor(private val remote: CommentRemote,
                                                private val mapper: CommentEntryMapper) : CommentRepository {

    override fun fetch(): Single<List<Comment>> = remote.fetch()
            .map { it.map(mapper::map) }

    override fun fetch(postId: Int): Single<List<Comment>> = remote.fetch(postId)
            .map { it.map(mapper::map) }
}