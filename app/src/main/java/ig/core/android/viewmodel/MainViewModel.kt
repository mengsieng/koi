package ig.core.android.viewmodel

import android.view.View
import android.widget.Toast
import ig.core.android.VMBaseNoModel
import ig.core.android.service.model.HomeModel

class MainViewModel : VMBaseNoModel() {

    fun getItem() : ArrayList<HomeModel> {
        val itemList: ArrayList<HomeModel> = ArrayList()
        for (i in 1..10) {
            val item = HomeModel("100$i", "Tony $i")
            itemList.add(item)
        }
        return itemList
    }

    fun onItemClick(view: View) {
        Toast.makeText(view.context, "Search Click", Toast.LENGTH_LONG).show()
    }
}