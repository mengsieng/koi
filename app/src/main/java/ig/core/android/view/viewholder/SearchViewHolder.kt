package ig.core.android.view.viewholder

import android.content.Context
import ig.core.android.BaseViewHolder
import ig.core.android.databinding.ItemSearchBinding
import ig.core.android.service.model.HomeModel

class SearchViewHolder(private val itemSearchBinding: ItemSearchBinding) : BaseViewHolder<HomeModel>(itemSearchBinding.root) {
    override fun bind(context: Context, item: HomeModel) {
        itemSearchBinding.itemSearch = item
    }
}