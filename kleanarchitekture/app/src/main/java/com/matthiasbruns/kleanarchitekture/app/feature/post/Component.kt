package com.matthiasbruns.kleanarchitekture.app.feature.post

import com.matthiasbruns.kleanarchitekture.app.feature.post.detail.PostDetailComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.detail.PostDetailModule
import com.matthiasbruns.kleanarchitekture.app.feature.post.list.PostListComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.list.PostListModule
import com.matthiasbruns.kleanarchitekture.data.comment.CommentRemote
import com.matthiasbruns.kleanarchitekture.data.comment.DataCommentRepository
import com.matthiasbruns.kleanarchitekture.data.post.DataPostRepository
import com.matthiasbruns.kleanarchitekture.data.post.PostRemote
import com.matthiasbruns.kleanarchitekture.domain.comment.CommentRepository
import com.matthiasbruns.kleanarchitekture.domain.post.PostRepository
import com.matthiasbruns.kleanarchitekture.presentation.post.PostNavigator
import com.matthiasbruns.kleanarchitekture.remote.ApiClient
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentApi
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentRemoteImpl
import com.matthiasbruns.kleanarchitekture.remote.post.PostApi
import com.matthiasbruns.kleanarchitekture.remote.post.PostRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class PostScope

@PostScope
@Subcomponent(modules = [PostModule::class])
interface PostComponent {

    fun plus(module: PostListModule): PostListComponent

    fun plus(module: PostDetailModule): PostDetailComponent
}

@Module
class PostModule {

    @PostScope
    @Provides
    fun provideRepository(repository: DataPostRepository): PostRepository = repository


    @PostScope
    @Provides
    fun provideNavigator(navigator: PostNavigatorImpl): PostNavigator = navigator

    @PostScope
    @Provides
    fun provideCommentRepository(repository: DataCommentRepository): CommentRepository = repository
}