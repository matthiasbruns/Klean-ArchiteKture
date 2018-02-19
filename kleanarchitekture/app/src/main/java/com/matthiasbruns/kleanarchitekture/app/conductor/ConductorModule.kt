package com.matthiasbruns.kleanarchitekture.app.conductor

import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConductorModule(private val routerProvider: RouterProvider) {

    @ConductorScope
    @Provides
    fun provideRouter(): Router = routerProvider.provide()

    @Provides
    fun provideControllerChangeHandler(): ControllerChangeHandler = HorizontalChangeHandler()

    @Provides
    @Named("modal")
    fun provideModalControllerChangeHandler(): ControllerChangeHandler = VerticalChangeHandler()
}