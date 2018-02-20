package com.matthiasbruns.kleanarchitekture.remote.user.mapper

import com.matthiasbruns.kleanarchitekture.commons.data.Mapper
import com.matthiasbruns.kleanarchitekture.data.user.model.CompanyEntry
import com.matthiasbruns.kleanarchitekture.remote.user.model.RemoteCompany
import javax.inject.Inject

class RemoteCompanyMapper @Inject constructor() : Mapper<RemoteCompany, CompanyEntry> {

    override fun map(from: RemoteCompany): CompanyEntry = with(from) {
        CompanyEntry(name = name,
                catchPhrase = catchPhrase,
                bs = bs)
    }
}