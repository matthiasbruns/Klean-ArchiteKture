package com.matthiasbruns.kleanarchitekture.commons.rx

import com.matthiasbruns.kleanarchitekture.commons.Logger
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface RxTimer {

    val onTimerTick: Subject<Long>

    fun start()

    fun pause(autoResume: Boolean = false)

    fun resume()

    fun stop()

    fun restart()
}

class RxTimerImpl @Inject constructor(private val period: Long = 5000L,
                                      private val timeUnit: TimeUnit = TimeUnit.MILLISECONDS,
                                      private val scheduler: Scheduler = Schedulers.io(),
                                      private val logger: Logger) : RxTimer {

    private var paused = false
    private var disposable: Disposable? = null
    private var autoResumeDisposable: Disposable? = null

    override val onTimerTick: Subject<Long> = PublishSubject.create<Long>()

    private fun createTimer(): Observable<Long> =
            Observable.interval(period, timeUnit, scheduler)
                    .filter { !paused }


    private fun createAutoResumeTimer(): Single<Long> =
            Observable.timer(period * 2, timeUnit, scheduler)
                    .firstOrError()

    @Synchronized override fun start() {
        logger.v("onStart()")
        // Only start once
        if (disposable != null && !disposable!!.isDisposed) {
            return
        }

        // Start new timer
        disposable = createTimer().subscribeBy { onTimerTick.onNext(it) }
    }

    override fun pause(autoResume: Boolean) {
        logger.v("pause(autoResume: $autoResume)")
        paused = true

        // Only start once
        autoResumeDisposable?.apply { dispose() }
        autoResumeDisposable = null

        if (autoResume) {
            autoResumeDisposable = createAutoResumeTimer()
                    .subscribeBy(onSuccess = {
                        logger.v("AutoResumeTimer::subscribeBy()")
                        resume()
                        autoResumeDisposable?.dispose()
                    })
        }
    }

    override fun resume() {
        logger.v("resume()")
        paused = false
    }

    @Synchronized override fun stop() {
        logger.v("stop()")
        disposable?.apply {
            dispose()
        }

        disposable = null
    }

    override fun restart() {
        logger.v("restart()")
        stop()
        start()
    }
}