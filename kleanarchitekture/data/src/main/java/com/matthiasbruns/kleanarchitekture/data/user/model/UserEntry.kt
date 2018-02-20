package com.matthiasbruns.kleanarchitekture.data.user.model

data class UserEntry(val id: Int,
                     val username: String,
                     val name: String?,
                     val email: String,
                     val phone: String?,
                     val website: String?,
                     val address: AddressEntry?,
                     val company: CompanyEntry?
)