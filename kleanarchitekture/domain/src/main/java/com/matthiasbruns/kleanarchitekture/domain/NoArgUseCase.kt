package com.matthiasbruns.kleanarchitekture.domain

interface NoArgUseCase<out RESULT> {

    fun execute(): RESULT

}