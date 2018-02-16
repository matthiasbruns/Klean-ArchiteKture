package com.matthiasbruns.kleanarchitekture.domain

interface UseCase<in PARAM, out RESULT> {

    fun execute(param: PARAM): RESULT

}