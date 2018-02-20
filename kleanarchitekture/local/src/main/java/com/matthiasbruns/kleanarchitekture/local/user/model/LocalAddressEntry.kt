package com.matthiasbruns.kleanarchitekture.local.user.model

data class LocalAddressEntry(val street: String,
                             val suite: String,
                             val city: String,
                             val zipCode: String,
                             val geo: LocalGeoEntry)