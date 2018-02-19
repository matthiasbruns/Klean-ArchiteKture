package com.matthiasbruns.kleanarchitekture.commons.data;

interface Provider<out RETURN> {

    fun provide(): RETURN
}