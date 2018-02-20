package com.matthiasbruns.kleanarchitekture.app.feature.user.formatter

import android.content.Context
import com.matthiasbruns.kleanarchitekture.app.R
import com.matthiasbruns.kleanarchitekture.app.feature.user.UserScope
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationAddressValueFormatter
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationCompanyValueFormatter
import com.matthiasbruns.kleanarchitekture.presentation.user.mapper.PresentationUserValueFormatter
import javax.inject.Inject

@UserScope
class PresentationUserFormatter @Inject constructor(private val context: Context) :
        PresentationUserValueFormatter,
        PresentationAddressValueFormatter,
        PresentationCompanyValueFormatter{

    override fun formatName(username: String, name: String?): String = context.getString(R.string.user_format_name, username, name)

    override fun formatAddress(street: String, city: String, suite: String, zipCode: String): String = context.getString(R.string.user_address_format_name, street, suite, zipCode, city)

    override fun formatCompany(name: String, catchPhrase: String, bs: String): String = context.getString(R.string.user_company_format_name, name, catchPhrase, bs)
}