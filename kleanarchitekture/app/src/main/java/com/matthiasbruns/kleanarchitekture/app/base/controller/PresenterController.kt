package com.matthiasbruns.kleanarchitekture.app.base.controller

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matthiasbruns.kleanarchitekture.presentation.Presenter
import com.matthiasbruns.kleanarchitekture.presentation.PresenterHolder

abstract class PresenterController<P : Presenter> : BaseController, PresenterHolder<P> {

    constructor() : super()

    constructor(args: Bundle) : super(args)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        retainViewMode = RetainViewMode.RETAIN_DETACH
        activity?.apply { injectDependencies(this) }
        presenter.onCreate()
        return inflateView(inflater, container)
    }

    abstract fun injectDependencies(context: Context)

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.onStart()
    }

    override fun onDetach(view: View) {
        presenter.onStop()
        super.onDetach(view)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}