package com.matthiasbruns.kleanarchitekture.commons.rx;

class RxOptional<out T> private constructor(val value: T?) {

    val isPresent: Boolean
        get() = value != null

    override fun equals(other: Any?) =
            when {
                this === other -> true
                other !is RxOptional<*> -> false
                else -> value == other.value
            }

    override fun hashCode() = value?.hashCode() ?: 0

    companion object {

        private val EMPTY by lazy { RxOptional(null) }

        fun <T> empty(): RxOptional<T> = EMPTY

        fun <T : Any> of(value: T) = RxOptional(value)

        fun <T> ofNullable(value: T?) = RxOptional(value)
    }
}
