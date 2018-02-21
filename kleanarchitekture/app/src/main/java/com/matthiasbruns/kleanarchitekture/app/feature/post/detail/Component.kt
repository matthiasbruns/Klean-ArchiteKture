package com.matthiasbruns.kleanarchitekture.app.feature.post.detail

import com.matthiasbruns.kleanarchitekture.presentation.post.detail.PostDetailView
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.presenter.PostDetailPresenter
import com.matthiasbruns.kleanarchitekture.presentation.post.detail.presenter.PostDetailPresenterImpl
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

    @PostDetailScope
    @Provides
    fun providePresenter(presenter: PostDetailPresenterImpl): PostDetailPresenter = presenter
}