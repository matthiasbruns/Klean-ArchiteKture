package com.matthiasbruns.kleanarchitekture.presentation.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.domain.user.model.Company
import com.matthiasbruns.kleanarchitekture.presentation.user.model.PresentationCompany
import javax.inject.Inject


interface PresentationCompanyValueFormatter {
    fun formatCompany(name: String, catchPhrase: String, bs: String): String
}

class PresentationCompanyMapper @Inject constructor(private val formatter: PresentationCompanyValueFormatter) : Mapper<Company, PresentationCompany> {

    override fun map(from: Company): PresentationCompany = with(from) {
        PresentationCompany(name = name,
                catchPhrase = catchPhrase,
                bs = bs,
                formattedCompany = formatter.formatCompany(name = name, bs = bs, catchPhrase = catchPhrase))
    }
}