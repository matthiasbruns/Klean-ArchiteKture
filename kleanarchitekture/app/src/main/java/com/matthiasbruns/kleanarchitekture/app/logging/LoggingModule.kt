package com.matthiasbruns.kleanarchitekture.app.logging

import com.matthiasbruns.kleanarchitekture.commons.Logger
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class LoggingModule {

    @Singleton
    @Binds
    abstract fun bindLogger(logger: LoggerImpl): Logger

}