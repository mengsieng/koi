package ig.core.android.view.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ig.core.android.BaseActivity
import ig.core.android.R
import ig.core.android.databinding.ActivityMainBinding
import ig.core.android.service.model.HomeModel
import ig.core.android.util.Constant
import ig.core.android.view.adapter.MainAdapter
import ig.core.android.view.callback.OnMainItemClickCallBack
import ig.core.android.view.ui.activity.detail.DetailActivity
import ig.core.android.viewmodel.MainViewModel
import java.util.Stack

class MainActivity : BaseActivity(), OnMainItemClickCallBack {
    lateinit var mBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    companion object {
        val fragments = Stack<Fragment>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = MainViewModel()
        onSetUpGeneralToolbar(getString(R.string.main_activity))

        mBinding.rvItemMain.also {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            it.setHasFixedSize(true)
            it.adapter = MainAdapter(this, mainViewModel.getItem(),this)
        }
    }

    override fun onItemClick(item: HomeModel) {
        sendBroadcast(Intent(Constant.CORE_ANDROID)) // testing purpose

        val bundle = Bundle()
        bundle.putParcelable("item", item)
        startNewActivityRight(DetailActivity::class.java, bundle,false)
    }
}
