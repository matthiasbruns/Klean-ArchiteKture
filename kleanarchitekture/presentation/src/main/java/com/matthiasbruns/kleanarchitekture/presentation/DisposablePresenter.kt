package com.matthiasbruns.kleanarchitekture.presentation

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class DisposablePresenter : Presenter {

    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    protected fun Disposable.disposeOnStop(): Unit {
        disposables.add(this)
    }
}