package com.matthiasbruns.kleanarchitekture.remote

import retrofit2.Response
import retrofit2.adapter.rxjava2.Result

object ApiError {

    fun <T> handleResult(result: Result<T>): T? =
            if (result.isError) {
                throw result.error() ?: Error("Could not load user")
            } else {
                result.response()?.let(this::handleResponse)
            }

    fun <T> handleResponse(response: Response<T>): T? {
        response.errorBody()?.let { throw Error(it.string()) }

        return response.raw()?.code()?.let { code ->
            when (code) {
                401 -> throw Error("Invalid credentials")
                else -> response.body()
            }
        }
    }
}