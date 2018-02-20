package com.matthiasbruns.kleanarchitekture.app.remote

import com.matthiasbruns.kleanarchitekture.data.album.AlbumRemote
import com.matthiasbruns.kleanarchitekture.data.comment.CommentRemote
import com.matthiasbruns.kleanarchitekture.data.photo.PhotoRemote
import com.matthiasbruns.kleanarchitekture.data.post.PostRemote
import com.matthiasbruns.kleanarchitekture.data.user.UserRemote
import com.matthiasbruns.kleanarchitekture.remote.album.AlbumRemoteImpl
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentRemoteImpl
import com.matthiasbruns.kleanarchitekture.remote.photo.PhotoRemoteImpl
import com.matthiasbruns.kleanarchitekture.remote.post.PostRemoteImpl
import com.matthiasbruns.kleanarchitekture.remote.user.UserRemoteImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class RemoteModule {

    @Singleton
    @Provides
    fun provideAlbumRemote(remote: AlbumRemoteImpl): AlbumRemote = remote

    @Singleton
    @Provides
    fun provideUserRemote(remote: UserRemoteImpl): UserRemote = remote

    @Singleton
    @Provides
    fun providePhotoRemote(remote: PhotoRemoteImpl): PhotoRemote = remote

    @Singleton
    @Provides
    fun provideCommentRemote(remote: CommentRemoteImpl): CommentRemote = remote

    @Singleton
    @Provides
    fun providePostRemote(remote: PostRemoteImpl): PostRemote = remote
}