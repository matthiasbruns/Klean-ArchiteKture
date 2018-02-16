package com.matthiasbruns.kleanarchitekture.commons

interface Logger {

    companion object {
        const val VERBOSE = 2
        const val DEBUG = 3
        const val INFO = 4
        const val WARN = 5
        const val ERROR = 6
        const val ASSERT = 7
    }

    fun mapPriority(priority: Int): Int

    fun log(priority: Int, tag: String, message: String, throwable: Throwable)
    fun d(message: String, vararg args: Any)
    fun d(data: Any)
    fun e(message: String, vararg args: Any)
    fun e(throwable: Throwable, message: String, vararg args: Any)
    fun i(message: String, vararg args: Any)
    fun v(message: String, vararg args: Any)
    fun w(message: String, vararg args: Any)
    fun wtf(message: String, vararg args: Any)
}