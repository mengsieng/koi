package ig.core.android.view.ui.activity.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import ig.core.android.R
import ig.core.android.BaseActivity
import ig.core.android.bind.binder.CompositeItemBinder
import ig.core.android.bind.binding.RecyclerViewBindings
import ig.core.android.bind.binding.RecyclerViewBindings.setItems
import ig.core.android.bind.listener.ClickHandler
import ig.core.android.binder.HomeDataBinder
import ig.core.android.service.model.HomeModel
import ig.core.android.view.adapter.HomePagerAdapter
import ig.core.android.view.itemviewmodel.ItemHomeViewModel
import ig.core.android.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast

class HomeActivity : BaseActivity() {
    /*private lateinit var mBinding: ActivityHomeBinding*/

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager!!.adapter = HomePagerAdapter(this)
        viewpager!!.offscreenPageLimit = 4
        viewpager!!.isUserInputEnabled = false
        TabLayoutMediator(tabs!!, viewpager!!, false, true) { tab, position ->
            when (position) {
                0 -> {
                    tab.icon = getDrawable(R.drawable.ic_home_selector)
                    tab.text = resources.getString(R.string.home_nav_label)
                }
                1 -> {
                    tab.icon = getDrawable(R.drawable.ic_card_selector)
                    tab.text = resources.getString(R.string.koi_pay_nav_label)
                }
                2 -> {
                    tab.icon = getDrawable(R.drawable.ic_scan_selector)
                    tab.text = resources.getString(R.string.scan_nav_label)
                }
                3 -> {
                    tab.icon = getDrawable(R.drawable.ic_store_selector)
                    tab.text = resources.getString(R.string.stores_nav_label)
                }
            }
        }.attach()
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (viewpager.currentItem == 0 && doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity()
            return
        } else if (viewpager.currentItem == 0 && !doubleBackToExitPressedOnce) {
            doubleBackToExitPressedOnce = true
            toast(getString(R.string.press_again_to_exit_application))
        } else {
            doubleBackToExitPressedOnce = true
            Handler(Looper.getMainLooper()).postDelayed({
                doubleBackToExitPressedOnce = false
            }, 2000)
            viewpager.currentItem = 0
        }
    }
}