package ig.core.android.view.ui.activity.detail

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ig.core.android.BaseActivity
import ig.core.android.R
import ig.core.android.databinding.ActivityDetailBinding
import ig.core.android.service.model.HomeModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {
    lateinit var mBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        onSetUpGeneralBackPressToolbar(getString(R.string.detail))

        val item = intent!!.extras!!.getParcelable<HomeModel>("item")
        text.text = item?.name
    }
}