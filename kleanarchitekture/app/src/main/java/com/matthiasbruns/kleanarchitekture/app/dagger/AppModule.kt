package com.matthiasbruns.kleanarchitekture.app.dagger

import android.content.Context
import com.matthiasbruns.kleanarchitekture.app.KleanApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class AppModule(private val app: KleanApp) {

    @Provides
    fun provideContext(): Context = app
}