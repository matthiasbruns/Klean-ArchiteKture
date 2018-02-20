package com.matthiasbruns.kleanarchitekture.data.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.CompanyEntry
import com.matthiasbruns.kleanarchitekture.domain.user.model.Company
import javax.inject.Inject

class CompanyEntryMapper @Inject constructor() : Mapper<CompanyEntry, Company> {

    override fun map(from: CompanyEntry): Company = with(from) {
        Company(name = name,
                catchPhrase = catchPhrase,
                bs = bs)
    }
}