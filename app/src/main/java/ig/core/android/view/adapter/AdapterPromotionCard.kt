package ig.core.android.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ig.core.android.BaseViewHolder
import ig.core.android.R
import ig.core.android.service.model.PromotionModel
import ig.core.android.view.viewholder.PromotionCardViewHolder

class AdapterPromotionCard(private val context: Context): RecyclerView.Adapter<BaseViewHolder<PromotionModel>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<PromotionModel> {
        return PromotionCardViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_promotion_card,parent,false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PromotionModel>, position: Int) {
        try {

        }catch (e: Exception){
            Log.e("err",e.localizedMessage)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}