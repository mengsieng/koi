package ig.core.android.binder

import ig.core.android.bind.binder.ConditionalDataBinder
import ig.core.android.viewmodel.HomeViewModel

class HomeDataBinder(bindingVariable:Int, layoutId:Int): ConditionalDataBinder<HomeViewModel>(bindingVariable, layoutId) {
    override fun canHandle(model: HomeViewModel): Boolean {
        return true
    }
}