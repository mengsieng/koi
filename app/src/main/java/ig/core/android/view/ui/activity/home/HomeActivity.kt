package ig.core.android.view.ui.activity.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.LinearLayoutManager
import ig.core.android.R
import ig.core.android.BaseActivity
import ig.core.android.bind.binder.CompositeItemBinder
import ig.core.android.bind.binding.RecyclerViewBindings
import ig.core.android.bind.binding.RecyclerViewBindings.setItems
import ig.core.android.bind.listener.ClickHandler
import ig.core.android.binder.HomeDataBinder
import ig.core.android.databinding.ActivityHomeBinding
import ig.core.android.service.model.HomeModel
import ig.core.android.view.itemviewmodel.ItemHomeViewModel
import ig.core.android.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), ClickHandler<HomeViewModel> {
    private lateinit var mBinding: ActivityHomeBinding
    private var mModels: ItemHomeViewModel? = null
    private var itemBinder = CompositeItemBinder(HomeDataBinder(BR.homeViewModel, R.layout.item_home))

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        onSetUpGeneralToolbar(getString(R.string.home))

        mModels = ItemHomeViewModel()
        setItems(rcl_home, mModels!!.items)
        RecyclerViewBindings.setItemViewBinder(rcl_home, itemBinder)
        RecyclerViewBindings.setHandler(rcl_home, this)
        mBinding.rclHome.layoutManager = LinearLayoutManager(this)

        loadData()
    }

    private fun loadData() {
        for (i in 1..20) {
            val item = HomeModel("100: $i","Orn Tony: $i")
            mModels!!.addItem(HomeViewModel(item))
        }
    }

    override fun onClick(viewModel: HomeViewModel, v: View) {
        Toast.makeText(this, "Click on: ${viewModel.getHome().id}", Toast.LENGTH_LONG).show()
    }
}