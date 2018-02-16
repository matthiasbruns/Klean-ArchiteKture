package com.matthiasbruns.kleanarchitekture.app.dagger

import com.matthiasbruns.kleanarchitekture.app.BuildConfig
import com.matthiasbruns.kleanarchitekture.remote.ApiClient
import com.matthiasbruns.kleanarchitekture.remote.ApiClientImpl
import com.matthiasbruns.kleanarchitekture.remote.ApiConfig
import com.matthiasbruns.kleanarchitekture.remote.Environment
import com.matthiasbruns.kleanarchitekture.remote.authentication.CredentialsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideApiConfig(): ApiConfig =
            ApiConfig(
                    environment = when (BuildConfig.DEBUG && !BuildConfig.BUILD_TYPE.toLowerCase().contains("beta")) {
                        true -> Environment.PRE
                        false -> Environment.PROD
                    }
            )

    @Singleton
    @Provides
    fun bindApiClient(client: ApiClientImpl): ApiClient = client

    @Provides
    fun bindCredentialsProvider(): CredentialsProvider =
            object : CredentialsProvider {
                // return a real provider if you need service auth
                override fun provide(): Pair<String, String>? = null
            }

}