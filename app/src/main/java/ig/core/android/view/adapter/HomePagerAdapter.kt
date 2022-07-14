package ig.core.android.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ig.core.android.view.ui.fragment.koiPay.KoiPayFragment
import ig.core.android.view.ui.fragment.promotion.PromotionFragment

class HomePagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    var fragment: Fragment? = null
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> fragment = PromotionFragment()
            1 -> fragment = KoiPayFragment()
            2 -> fragment = PromotionFragment()
            3 -> fragment = KoiPayFragment()
        }
        return fragment!!
    }

    override fun getItemCount(): Int = 4
}