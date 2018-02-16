package com.matthiasbruns.kleanarchitekture.presentation

interface PresenterHolder<out P : Presenter> {

    val presenter: P

}