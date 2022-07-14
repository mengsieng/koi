package ig.core.android.view.ui.fragment.koiPay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ig.core.android.BaseFragment
import ig.core.android.R

class KoiPayFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_koi_pay, container, false)
    }

}