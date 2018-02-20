package com.matthiasbruns.kleanarchitekture.local.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.BiDirectionalMapper
import com.matthiasbruns.kleanarchitekture.data.user.model.CompanyEntry
import com.matthiasbruns.kleanarchitekture.local.user.model.LocalCompanyEntry
import javax.inject.Inject

class LocalCompanyEntryMapper @Inject constructor() : BiDirectionalMapper<LocalCompanyEntry, CompanyEntry> {

    override fun mapFrom(from: CompanyEntry): LocalCompanyEntry = with(from) {
        LocalCompanyEntry(name = name,
                bs = bs,
                catchPhrase = catchPhrase)
    }

    override fun mapTo(from: LocalCompanyEntry): CompanyEntry = with(from) {
        CompanyEntry(name = name,
                bs = bs,
                catchPhrase = catchPhrase)
    }
}