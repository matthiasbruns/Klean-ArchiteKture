package com.matthiasbruns.kleanarchitekture.commons.data;

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}


interface BiDirectionalMapper<FROM, TO> {

    fun mapTo(from: FROM): TO

    fun mapFrom(from: TO): FROM
}