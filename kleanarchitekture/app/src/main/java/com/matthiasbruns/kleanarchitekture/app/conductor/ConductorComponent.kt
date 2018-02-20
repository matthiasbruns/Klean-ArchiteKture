package com.matthiasbruns.kleanarchitekture.app.conductor

import com.matthiasbruns.kleanarchitekture.app.feature.post.PostComponent
import com.matthiasbruns.kleanarchitekture.app.feature.post.PostModule
import com.matthiasbruns.kleanarchitekture.app.feature.user.UserComponent
import com.matthiasbruns.kleanarchitekture.app.feature.user.UserModule
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ConductorScope

@ConductorScope
@Subcomponent(
        modules = [ConductorModule::class]
)
interface ConductorComponent {

    fun plus(module: PostModule): PostComponent

    fun plus(module: UserModule): UserComponent
}