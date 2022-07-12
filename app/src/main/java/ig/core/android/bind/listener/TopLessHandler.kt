package ig.core.android.bind.listener

abstract class TopLessHandler {
    var offset = 2
    var isLoading = false

    abstract fun onLoad(pos: Int)
}