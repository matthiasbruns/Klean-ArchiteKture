package com.matthiasbruns.kleanarchitekture.remote.authentication

import com.matthiasbruns.kleanarchitekture.commons.data.Provider


interface CredentialsProvider : Provider<Pair<String, String>?>