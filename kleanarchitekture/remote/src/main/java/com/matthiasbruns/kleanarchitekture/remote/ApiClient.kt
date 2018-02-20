package com.matthiasbruns.kleanarchitekture.remote

import com.matthiasbruns.kleanarchitekture.remote.album.AlbumApi
import com.matthiasbruns.kleanarchitekture.remote.authentication.AuthenticationInterceptor
import com.matthiasbruns.kleanarchitekture.remote.authentication.CredentialsProvider
import com.matthiasbruns.kleanarchitekture.remote.comment.CommentApi
import com.matthiasbruns.kleanarchitekture.remote.photo.PhotoApi
import com.matthiasbruns.kleanarchitekture.remote.post.PostApi
import com.matthiasbruns.kleanarchitekture.remote.user.UserApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface ApiClient {

    val comment: CommentApi

    val post: PostApi

    val user: UserApi

    val album: AlbumApi

    val photo: PhotoApi
}

class ApiClientImpl @Inject constructor(private val config: ApiConfig,
                                        private val credentialsProvider: CredentialsProvider) : ApiClient {

    companion object {
        const val ENDPOINT_PRE = "https://jsonplaceholder.typicode.com/"
        const val ENDPOINT_PROD = "https://jsonplaceholder.typicode.com/"
    }

    private val httpClientBuilder: OkHttpClient.Builder by lazy {
        val builder = OkHttpClient.Builder()

        if (config.environment == Environment.PRE) {
            builder.connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
        }

        builder
    }

    private val moshi: Moshi
        get() = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

    private val builder = Retrofit.Builder()
            .baseUrl(
                    when (config.environment) {
                        Environment.PRE -> ENDPOINT_PRE
                        Environment.PROD -> ENDPOINT_PROD
                    })

            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    private var retrofit: Retrofit = builder.build()

    private fun <S> createService(serviceClass: Class<S>): S {
        val interceptor = AuthenticationInterceptor(credentialsProvider)

        if (!httpClientBuilder.interceptors().contains(interceptor)) {
            httpClientBuilder.interceptors().add(interceptor)

            builder.client(httpClientBuilder.build())
            retrofit = builder.build()
        }

        return retrofit.create(serviceClass)
    }

    override val comment: CommentApi
        get() {
            return createService(CommentApi::class.java)
        }

    override val post: PostApi
        get() {
            return createService(PostApi::class.java)
        }

    override val user: UserApi
        get() {
            return createService(UserApi::class.java)
        }

    override val album: AlbumApi
        get() {
            return createService(AlbumApi::class.java)
        }

    override val photo: PhotoApi
        get() {
            return createService(PhotoApi::class.java)
        }
}