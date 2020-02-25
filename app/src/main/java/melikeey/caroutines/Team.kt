package melikeey.caroutines

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val title: String, val subTitle: String, val detail: String, val president : String, val url : String)
    : Parcelable