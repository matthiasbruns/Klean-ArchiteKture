package com.matthiasbruns.kleanarchitekture.local.user.model

data class LocalUserEntry(val id: Int,
                          val username: String,
                          val name: String?,
                          val email: String,
                          val phone: String?,
                          val website: String?,
                          val address: LocalAddressEntry?,
                          val company: LocalCompanyEntry?
)