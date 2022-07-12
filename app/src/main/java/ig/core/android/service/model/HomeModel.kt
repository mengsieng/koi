package ig.core.android.service.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeModel(val _id: String? = "", val _name: String? = "") : Parcelable {
    @IgnoredOnParcel
    var id = _id
    @IgnoredOnParcel
    var name = _name
}