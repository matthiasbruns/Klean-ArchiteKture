package com.matthiasbruns.kleanarchitekture.remote.comment

import com.matthiasbruns.kleanarchitekture.data.comment.CommentRemote
import com.matthiasbruns.kleanarchitekture.data.comment.model.CommentEntry
import com.matthiasbruns.kleanarchitekture.remote.ApiError
import com.matthiasbruns.kleanarchitekture.remote.comment.mapper.RemoteCommentMapper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CommentRemoteImpl @Inject constructor(private val api: CommentApi,
                                            private val mapper: RemoteCommentMapper) : CommentRemote {

    override fun fetch(): Single<List<CommentEntry>> = api.fetch()
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }


    override fun fetch(postId: Int): Single<List<CommentEntry>> = api.fetch(postId)
            .subscribeOn(Schedulers.io())
            .map { ApiError.handleResult(it) ?: emptyList() }
            .map { it.map(mapper::map) }

}