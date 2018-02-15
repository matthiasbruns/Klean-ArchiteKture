package com.matthiasbruns.kleanarchitekture.remote.authentication;

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthenticationInterceptor(private val credentialsProvider: CredentialsProvider) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val provide = credentialsProvider.provide()

        return provide?.let {
            val token = Credentials.basic(it.first, it.second)
            val original = chain.request()

            val builder = original.newBuilder().header("Authorization", token)

            val request = builder.build()
            chain.proceed(request)
        } ?: chain.proceed(chain.request())
    }
}