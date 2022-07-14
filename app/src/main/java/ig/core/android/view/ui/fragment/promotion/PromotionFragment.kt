package ig.core.android.view.ui.fragment.promotion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ig.core.android.BaseFragment
import ig.core.android.R
import ig.core.android.view.adapter.AdapterPromotionCard
import kotlinx.android.synthetic.main.fragment_promotion.*
import org.json.JSONArray

class PromotionFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_promotion, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        recycler_home_banner.adapter = AdapterPromotionCard(requireContext())
    }

}