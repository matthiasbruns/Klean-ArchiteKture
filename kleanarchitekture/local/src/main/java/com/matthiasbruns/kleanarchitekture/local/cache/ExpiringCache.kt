package com.matthiasbruns.kleanarchitekture.local.cache

data class Entry<out T>(val item: T, val expireAt: Long)

abstract class ExpiringCache<T, ID>(val cachingTime: Long = 1000 * 60) : Cache<T, ID> {

    private val cache = mutableMapOf<ID, Entry<T>>()

    override fun get(id: ID): T? = cache[id]?.let {
        if (it.expireAt > System.currentTimeMillis()) {
            it.item
        } else {
            remove(getId(it.item))
            null
        }
    }

    override fun update(item: T) {
        cache[getId(item)] = Entry(item, System.currentTimeMillis() + cachingTime)
    }

    override fun remove(id: ID) {
        cache.remove(id)
    }

    override fun invalidate() {
        cache.clear()
    }

    abstract fun getId(item: T): ID
}