package com.matthiasbruns.kleanarchitekture.data.user.model

data class AddressEntry(val street: String,
                        val suite: String,
                        val city: String,
                        val zipCode: String,
                        val geo: GeoEntry)