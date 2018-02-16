package com.matthiasbruns.kleanarchitekture.app.feature.post.list

import com.matthiasbruns.kleanarchitekture.presentation.post.list.PostListView
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class PostListScope

@PostListScope
@Subcomponent(modules = [PostListModule::class])
interface PostListComponent {

    fun inject(target: PostListController)
}

@Module
class PostListModule(private val view: PostListView) {

    @PostListScope
    @Provides
    fun provideView(): PostListView = view
}