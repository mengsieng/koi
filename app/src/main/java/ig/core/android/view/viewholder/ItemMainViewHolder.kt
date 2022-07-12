package ig.core.android.view.viewholder

import android.content.Context
import ig.core.android.BaseViewHolder
import ig.core.android.databinding.ItemMainBinding
import ig.core.android.service.model.HomeModel

class ItemMainViewHolder(private val itemMainBinding: ItemMainBinding) : BaseViewHolder<HomeModel>(itemMainBinding.root) {
    override fun bind(context: Context, item: HomeModel) {
        itemMainBinding.itemMainViewModel = item
    }
}