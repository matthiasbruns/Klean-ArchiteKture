package com.matthiasbruns.kleanarchitekture.app.feature.user

import com.matthiasbruns.kleanarchitekture.app.feature.user.detail.UserDetailComponent
import com.matthiasbruns.kleanarchitekture.app.feature.user.detail.UserDetailModule
import com.matthiasbruns.kleanarchitekture.app.feature.user.formatter.PresentationUserFormatter
import com.matthiasbruns.kleanarchitekture.data.album.DataAlbumRepository
import com.matthiasbruns.kleanarchitekture.data.photo.DataPhotoRepository
import com.matthiasbruns.kleanarchitekture.data.user.AdvancedDataUserRepository
import com.matthiasbruns.kleanarchitekture.domain.album.AlbumRepository
import com.matthiasbruns.kleanarchitekture.domain.photo.PhotoRepository
import com.matthiasbruns.kleanarchitekture.domain.user.UserRepository
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationAddressValueFormatter
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationCompanyValueFormatter
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationUserValueFormatter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class UserScope

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserComponent {

    fun plus(module: UserDetailModule): UserDetailComponent

}

@Module
class UserModule {

    @UserScope
    @Provides
    fun providePresentationUserValueFormatter(formatter: PresentationUserFormatter): PresentationUserValueFormatter = formatter

    @UserScope
    @Provides
    fun providePresentationAddressValueFormatter(formatter: PresentationUserFormatter): PresentationAddressValueFormatter = formatter

    @UserScope
    @Provides
    fun providePresentationCompanyValueFormatter(formatter: PresentationUserFormatter): PresentationCompanyValueFormatter = formatter


    @UserScope
    @Provides
    fun provideAlbumRepository(repository: DataAlbumRepository): AlbumRepository = repository

    @UserScope
    @Provides
    fun providePhotoRepository(repository: DataPhotoRepository): PhotoRepository = repository

//    @UserScope
//    @Provides
//    fun provideRepository(repository: DataUserRepository): UserRepository = repository

    @UserScope
    @Provides
    fun provideRepository(repository: AdvancedDataUserRepository): UserRepository = repository
}