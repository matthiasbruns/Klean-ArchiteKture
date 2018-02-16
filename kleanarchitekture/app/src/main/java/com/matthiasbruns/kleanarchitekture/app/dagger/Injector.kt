package com.matthiasbruns.kleanarchitekture.app.dagger

import com.matthiasbruns.kleanarchitekture.app.KleanApp

object Injector {

    fun init(app: KleanApp): AppComponent {
        val component = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()

        component.inject(app)
        return component
    }
}