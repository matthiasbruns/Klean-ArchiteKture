package com.matthiasbruns.kleanarchitekture.presentation.user.model

data class PresentationUser(val id: Int,
                            val username: String,
                            val name: String?,
                            val email: String,
                            val phone: String?,
                            val website: String?,
                            val address: PresentationAddress?,
                            val company: PresentationCompany?,
                            val formattedName: String
)