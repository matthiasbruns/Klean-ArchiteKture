package com.matthiasbruns.kleanarchitekture.app.feature.post.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ParcelablePresentationPost(val id: Int,
                                 val userId: Int,
                                 val formattedUserId: String,
                                 val title: String,
                                 val body: String) : Parcelable