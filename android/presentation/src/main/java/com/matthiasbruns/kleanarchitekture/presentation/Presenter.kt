package com.matthiasbruns.kleanarchitekture.presentation

interface Presenter {

    fun onCreate() {}

    fun onStart() {}

    fun onStop() {}

    fun onDestroy() {}
}

