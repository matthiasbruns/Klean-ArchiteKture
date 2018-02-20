package com.matthiasbruns.kleanarchitekture.app.dagger

import com.matthiasbruns.kleanarchitekture.app.KleanApp
import com.matthiasbruns.kleanarchitekture.app.conductor.ConductorComponent
import com.matthiasbruns.kleanarchitekture.app.conductor.ConductorModule
import com.matthiasbruns.kleanarchitekture.app.local.LocalModule
import com.matthiasbruns.kleanarchitekture.app.logging.LoggingModule
import com.matthiasbruns.kleanarchitekture.app.remote.RemoteModule
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
            LoggingModule::class,
            RemoteModule::class,
            LocalModule::class
        ]
)
interface AppComponent {

    fun plus(module: ConductorModule): ConductorComponent

    fun inject(application: KleanApp)

    fun uiScheduler(): Scheduler

    fun apiClient(): ApiClient

    fun logger(): Logger
}