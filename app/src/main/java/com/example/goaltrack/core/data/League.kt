// League.kt
package com.example.goaltrack.core.data

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val name: String,
    val country: String,
    val imageUrl: String
): Parcelable
