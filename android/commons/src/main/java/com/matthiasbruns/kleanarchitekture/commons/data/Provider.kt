package com.matthiasbruns.kleanarchitekture.commons.data;

interface Provider<out TO> {

    fun provide(): TO
}