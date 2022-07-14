package ig.core.android.bind.listener

import android.view.View

interface ClickHandler<T> {
    fun onClick(viewModel: T, v: View)
}