package com.matthiasbruns.kleanarchitekture.commons.data;

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}

interface MapperWithArgs<in FROM, out TO, in ARGS> {

    fun map(from: FROM, args: ARGS): TO
}

interface BiDirectionalMapper<FROM, TO> {

    fun mapTo(from: FROM): TO

    fun mapFrom(from: TO): FROM
}