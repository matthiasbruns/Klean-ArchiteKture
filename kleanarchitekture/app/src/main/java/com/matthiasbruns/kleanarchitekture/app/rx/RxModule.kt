package com.matthiasbruns.kleanarchitekture.app.rx

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Singleton
@Module
class RxModule {

    @Provides
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}