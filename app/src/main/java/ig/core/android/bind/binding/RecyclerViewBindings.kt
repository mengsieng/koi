package ig.core.android.bind.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ig.core.android.bind.adapter.BindingRecyclerViewAdapter
import ig.core.android.bind.binder.ItemBinder
import ig.core.android.bind.listener.ClickHandler
import ig.core.android.bind.listener.LongClickHandler
import ig.core.android.bind.listener.RecyclerScrollHandler
import ig.core.android.bind.listener.TopLessHandler
import ig.core.android.bind.utils.SpacesItemDecoration

object RecyclerViewBindings {
    private const val KEY_ITEMS = -123
    private const val KEY_CLICK_HANDLER = -124
    private const val KEY_LONG_CLICK_HANDLER = -125
    private const val KEY_END_LESS_HANDLER = -126

    @BindingAdapter("items")
    fun <T> setItems(recyclerView: RecyclerView, items: Collection<T>) {
        val adapter = recyclerView.adapter as BindingRecyclerViewAdapter<T>?
        if (adapter != null) {
            adapter.setItems(items)
        } else {
            recyclerView.setTag(KEY_ITEMS, items)
        }
    }

    @BindingAdapter("clickHandler")
    fun <T> setHandler(recyclerView: RecyclerView, handler: ClickHandler<T>) {
        val adapter = recyclerView.adapter as BindingRecyclerViewAdapter<T>?
        if (adapter != null) {
            adapter.setClickHandler(handler)
        } else {
            recyclerView.setTag(KEY_CLICK_HANDLER, handler)
        }
    }


    @BindingAdapter("longClickHandler")
    fun <T> setHandler(recyclerView: RecyclerView, handler: LongClickHandler<T>) {
        val adapter = recyclerView.adapter as BindingRecyclerViewAdapter<T>?
        if (adapter != null) {
            adapter.setLongClickHandler(handler)
        } else {
            recyclerView.setTag(KEY_LONG_CLICK_HANDLER, handler)
        }
    }

    @BindingAdapter("android:orientation")
    fun setOrientation(recyclerView: RecyclerView, orientation: Int) {
        try {
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            layoutManager.orientation = orientation
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @BindingAdapter("endLessHandler")
    fun <T> setHandler(recyclerView: RecyclerView, handler: RecyclerScrollHandler) {
        val adapter = recyclerView.adapter as BindingRecyclerViewAdapter<T>?
        if (adapter != null) {
            /*if (handler.layoutManager == null)
                handler.layoutManager = recyclerView.layoutManager
            recyclerView.addOnScrollListener(handler)*/
        } else {
            recyclerView.setTag(KEY_END_LESS_HANDLER, handler)
        }
    }

    @BindingAdapter("topLessHandler")
    fun <T> setHandler(recyclerView: RecyclerView, handler: TopLessHandler) {
    }

    @BindingAdapter(value = *arrayOf("hasFixedSize", "nestedScroll"), requireAll = true)
    fun <T> setOption(recyclerView: RecyclerView, hasFixed: Boolean, nested: Boolean) {
        recyclerView.setHasFixedSize(hasFixed)
        recyclerView.isNestedScrollingEnabled = nested
    }

    @BindingAdapter("itemViewBinder")
    fun <T> setItemViewBinder(recyclerView: RecyclerView, itemViewMapper: ItemBinder<T>) {
        try {
            val items = recyclerView.getTag(KEY_ITEMS) as Collection<T>?
            val clickHandler = recyclerView.getTag(KEY_CLICK_HANDLER) as ClickHandler<T>?
            val adapter = BindingRecyclerViewAdapter(itemViewMapper, items)
            if (clickHandler != null) {
                adapter.setClickHandler(clickHandler)
            }

            recyclerView.adapter = adapter
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    @BindingAdapter("itemAnimDuration")
    fun setAnimItem(recyclerView: RecyclerView, duration: Int) {
        val itemAnimator = DefaultItemAnimator()
        itemAnimator.addDuration = duration.toLong()
        itemAnimator.removeDuration = duration.toLong()
        recyclerView.itemAnimator = itemAnimator
    }

    @BindingAdapter("itemSpace")
    fun itemDecoration(recyclerView: RecyclerView, space: Int) {
        val itemDecoration = SpacesItemDecoration(space)
        recyclerView.addItemDecoration(itemDecoration)
    }
}