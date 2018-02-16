package com.matthiasbruns.kleanarchitekture.app.dagger

import com.matthiasbruns.kleanarchitekture.app.KleanApp
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostModule
import com.matthiasbruns.kleanarchitekture.app.logging.LoggingModule
import com.matthiasbruns.kleanarchitekture.app.rx.RxModule
import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.matthiasbruns.kleanarchitekture.remote.ApiClient
import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            RxModule::class,
            ApiModule::class,
            LoggingModule::class
        ]
)
interface AppComponent {

    fun inject(application: KleanApp)

    fun plus(module: PostModule): PostComponent

    fun uiScheduler(): Scheduler

    fun apiClient(): ApiClient

    fun logger(): Logger
}