package ig.core.android.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ig.core.android.BaseViewHolder
import ig.core.android.R
import ig.core.android.service.model.HomeModel
import ig.core.android.view.callback.OnMainItemClickCallBack
import ig.core.android.view.viewholder.ItemMainViewHolder
import ig.core.android.view.viewholder.SearchViewHolder

@Suppress("UNREACHABLE_CODE")
class MainAdapter(private val context: Context, private val itemList: ArrayList<HomeModel>, private var listenerMain: OnMainItemClickCallBack) : RecyclerView.Adapter<BaseViewHolder<HomeModel>>() {

    companion object {
        private const val TYPE_SEARCH = 1
        private const val TYPE_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HomeModel> {
        when (viewType) {
            TYPE_SEARCH -> return SearchViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_search,
                    parent,
                    false
                )
            )
            TYPE_ITEM -> return ItemMainViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_main,
                    parent,
                    false
                )
            )
            else -> return null!!
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder<HomeModel>, position: Int) {
        val list = itemList[position]

        when (holder.itemViewType) {
            TYPE_SEARCH -> holder.bind(context, list)
            TYPE_ITEM -> {
                holder.bind(context, list)
                holder.itemView.setOnClickListener { listenerMain.onItemClick(itemList[position]) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position].id) {
            "1001" -> TYPE_SEARCH
            else -> TYPE_ITEM
        }
    }
}