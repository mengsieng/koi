package ig.core.android.bind.listener

import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerScrollHandler
    (private val mLinearLayoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var previousTotal = 0
    private var totalItemCount: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val handler = Handler()
        val r = Runnable {
            val visibleItemCount = recyclerView.childCount
            totalItemCount = mLinearLayoutManager.itemCount
            val firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition()
            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false
                    previousTotal = totalItemCount
                }
            }

            if (!loading && visibleItemCount + firstVisibleItemPosition >= totalItemCount
                && firstVisibleItemPosition >= 0
                && totalItemCount >= 10) {
                onLoadMore()
                loading = true
            }
        }
        handler.post(r)
    }

    abstract fun onLoadMore()

    fun reset() {
        previousTotal = 0
    }

    companion object {
        var loading = true
    }
}