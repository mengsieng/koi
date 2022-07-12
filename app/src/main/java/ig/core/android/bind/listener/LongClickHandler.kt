package ig.core.android.bind.listener

import android.view.View

interface LongClickHandler<T> {
    fun onLongClick(viewModel: T, v: View)
}