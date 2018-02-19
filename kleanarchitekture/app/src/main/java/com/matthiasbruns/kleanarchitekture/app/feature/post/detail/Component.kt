package com.matthiasbruns.kleanarchitekture.app.feature.post.detail

import com.matthiasbruns.kleanarchitekture.presentation.post.detail.PostDetailView
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class PostDetailScope

@PostDetailScope
@Subcomponent(modules = [
    PostDetailModule::class
])
interface PostDetailComponent {

    fun inject(target: PostDetailController)
}

@Module
class PostDetailModule(private val view: PostDetailView) {

    @PostDetailScope
    @Provides
    fun provideView(): PostDetailView = view
}