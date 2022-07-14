package ig.core.android.view.viewholder

import android.content.Context
import androidx.core.content.ContextCompat
import ig.core.android.BaseViewHolder
import ig.core.android.R
import ig.core.android.databinding.ItemPromotionCardBinding
import ig.core.android.service.model.PromotionModel

class PromotionCardViewHolder(private val itemPromotionCard: ItemPromotionCardBinding): BaseViewHolder<PromotionModel>(itemPromotionCard.root) {
    override fun bind(context: Context, item: PromotionModel) {
        itemPromotionCard.itemPromotionCard = item
        //val imgUrl = context.resources.getIdentifier(context.packageName+ ":drawable/" + item.imageUrl, null, null)
        itemPromotionCard.imgCard.setImageResource(R.drawable.img_banner)
    }
}