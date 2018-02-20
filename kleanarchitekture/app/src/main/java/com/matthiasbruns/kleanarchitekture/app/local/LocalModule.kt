package com.matthiasbruns.kleanarchitekture.app.local

import com.matthiasbruns.kleanarchitekture.data.user.AdvancedDataUserRepository
import com.matthiasbruns.kleanarchitekture.data.user.UserLocal
import com.matthiasbruns.kleanarchitekture.local.user.UserLocalImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideLocal(local: UserLocalImpl): UserLocal = local
}