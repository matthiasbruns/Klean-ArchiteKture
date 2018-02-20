package com.matthiasbruns.kleanarchitekture.local.cache

interface Cache<T, in ID> {

    fun get(id: ID): T?

    fun update(item: T)

    fun remove(id: ID)

    fun invalidate()
}