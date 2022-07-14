package ig.core.android

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import java.util.*

abstract class VMBaseItem<T : VMBase<*>> : BaseObservable() {
    @Bindable
    var items: ObservableList<T>
    private val tempItems: ObservableList<T>

    init {
        items = ObservableArrayList()
        tempItems = ObservableArrayList()
    }

    open fun addItem(item: T) {
        val index = items.indexOf(item)
        if (index > -1) {
            items[index] = item
        } else {
            items.add(item)
        }
    }

    fun addItem(index: Int, item: T) {
        if (index > -1 && index < items.size) {
            val index2 = items.indexOf(item)
            if (index2 > -1)
                items[index2] = item
            items.add(index, item)
        } else {
            items.add(item)
        }
    }

    fun setItems(items: Collection<T>) {
        for (item in items) {
            addItem(item)
        }
    }

    @Throws(Exception::class)
    fun getItem(pos: Int): T {
        if (items.size == 0)
            throw IllegalStateException("Item size is 0.")
        return items[pos]
    }

    @Throws(Exception::class)
    fun remove(item: T) {
        if (items.size == 0)
            throw IllegalStateException("Item size is 0.")
        items.remove(item)
    }

    fun removeAll() {
        if (items.size > 0)
            items.clear()
    }

    protected fun sortBy(comparator: Comparator<T>) {
        Collections.sort(items, comparator)
    }
}
