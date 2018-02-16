package com.matthiasbruns.kleanarchitekture.app

import android.app.Application
import android.content.Context
import com.matthiasbruns.kleanarchitekture.app.dagger.Injector
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostModule

class KleanApp : Application() {

    companion object {

        fun instance(context: Context): KleanApp? = context.applicationContext as? KleanApp

    }

    val component by lazy { Injector.init(this) }

    val postComponent: PostComponent by lazy { component.plus(PostModule()) }

    override fun onCreate() {
        super.onCreate()
    }
}