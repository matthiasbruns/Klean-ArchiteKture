package com.matthiasbruns.kleanarchitekture.app.remote

import com.matthiasbruns.kleanarchitekture.remote.ApiClient
import com.matthiasbruns.kleanarchitekture.remote.album.AlbumApi
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentApi
import com.matthiasbruns.kleanarchitekture.remote.photo.PhotoApi
import com.matthiasbruns.kleanarchitekture.remote.post.PostApi
import com.matthiasbruns.kleanarchitekture.remote.user.UserApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideAlbumApi(apiClient: ApiClient): AlbumApi = apiClient.album

    @Singleton
    @Provides
    fun provideUserApi(apiClient: ApiClient): UserApi = apiClient.user

    @Singleton
    @Provides
    fun providePhotoApi(apiClient: ApiClient): PhotoApi = apiClient.photo

    @Singleton
    @Provides
    fun provideApi(client: ApiClient): PostApi = client.post

    @Singleton
    @Provides
    fun provideCommentApi(client: ApiClient): CommentApi = client.comment

}