package ig.core.android.viewmodel

import ig.core.android.VMBase
import ig.core.android.service.model.HomeModel

class HomeViewModel(private val home: HomeModel) : VMBase<HomeModel>(home) {

    fun getHome(): HomeModel {
        return home
    }

    override fun hashCode(): Int {
        return home.hashCode()
    }

    /* fun itemClick(view: View, home: HomeModel) {
        Toast.makeText(view.context, "Click on: ${home.id}", Toast.LENGTH_LONG).show()
    } */

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as HomeViewModel

        if (home != other.home) return false

        return true
    }
}