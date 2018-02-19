package com.matthiasbruns.kleanarchitekture.app.feature.comment

import com.matthiasbruns.kleanarchitekture.data.comment.CommentRemote
import com.matthiasbruns.kleanarchitekture.data.comment.DataCommentRepository
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.remote.ApiClient
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentApi
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class CommentScope

@CommentScope
@Subcomponent(modules = [CommentModule::class])
interface CommentComponent {

}

@Module
class CommentModule {

    @CommentScope
    @Provides
    fun provideRepository(repository: DataCommentRepository): CommentRepository = repository

    @CommentScope
    @Provides
    fun provideRemote(remote: CommentRemoteImpl): CommentRemote = remote

    @CommentScope
    @Provides
    fun provideApi(client: ApiClient): CommentApi = client.comment
}