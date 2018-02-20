package com.matthiasbruns.kleanarchitekture.presentation.user.model

data class PresentationAddress(val street: String,
                               val suite: String,
                               val city: String,
                               val zipCode: String,
                               val geo: PresentationGeo,
                               val formattedAddress: String?)