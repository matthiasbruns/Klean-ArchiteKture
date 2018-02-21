package com.matthiasbruns.kleanarchitekture.app.feature.user.detail

import com.matthiasbruns.kleanarchitekture.presentation.user.detail.UserDetailView
import com.matthiasbruns.kleanarchitekture.presentation.user.detail.presenter.UserDetailPresenter
import com.matthiasbruns.kleanarchitekture.presentation.user.detail.presenter.UserDetailPresenterImpl
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class UserDetailScope

@UserDetailScope
@Subcomponent(modules = [UserDetailModule::class])
interface UserDetailComponent {

    fun inject(target: UserDetailController)

}

@Module
class UserDetailModule(private val view: UserDetailView) {

    @UserDetailScope
    @Provides
    fun provideView(): UserDetailView = view

    @UserDetailScope
    @Provides
    fun providePresenter(presenter: UserDetailPresenterImpl) : UserDetailPresenter = presenter
}