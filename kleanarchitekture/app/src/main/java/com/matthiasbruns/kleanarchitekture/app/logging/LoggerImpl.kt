package com.matthiasbruns.kleanarchitekture.app.logging

import com.matthiasbruns.kleanarchitekture.commons.Logger
import com.orhanobut.logger.AndroidLogAdapter
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    init {
        com.orhanobut.logger.Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun mapPriority(priority: Int): Int =
            when (priority) {
                Logger.VERBOSE -> com.orhanobut.logger.Logger.VERBOSE
                Logger.DEBUG -> com.orhanobut.logger.Logger.DEBUG
                Logger.INFO -> com.orhanobut.logger.Logger.INFO
                Logger.WARN -> com.orhanobut.logger.Logger.WARN
                Logger.ERROR -> com.orhanobut.logger.Logger.ERROR
                Logger.ASSERT -> com.orhanobut.logger.Logger.ASSERT
                else -> com.orhanobut.logger.Logger.INFO
            }

    override fun log(priority: Int, tag: String, message: String, throwable: Throwable) {
        com.orhanobut.logger.Logger.log(mapPriority(priority), tag, message, throwable)
    }

    override fun d(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.d(message, *args)
    }

    override fun d(data: Any) {
        com.orhanobut.logger.Logger.d(data)
    }

    override fun e(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.e(message, *args)
    }

    override fun e(throwable: Throwable, message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.e(throwable, message, *args)
    }

    override fun i(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.i(message, *args)
    }

    override fun v(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.v(message, *args)
    }

    override fun w(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.w(message, *args)
    }

    override fun wtf(message: String, vararg args: Any) {
        com.orhanobut.logger.Logger.wtf(message, *args)
    }
}