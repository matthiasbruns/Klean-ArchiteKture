package com.matthiasbruns.kleanarchitekture.app

import android.app.Application
import android.content.Context
import com.matthiasbruns.kleanarchitekture.app.dagger.AppComponent
import com.matthiasbruns.kleanarchitekture.app.dagger.Injector

class KleanApp : Application() {

    companion object {

        fun instance(context: Context): KleanApp? = context.applicationContext as? KleanApp
    }

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = Injector.init(this)
    }
}