package ig.core.android

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.content.ContextCompat
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

/****
 *
 * Created by ORN TONY on 01/01/19.
 *
 */

abstract class BaseFragment : androidx.fragment.app.Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ContextCompat.getColor(context!!, R.color.color_background))
    }

    protected fun onAlertError(message: String = "Error message") {
        activity?.runOnUiThread {
            activity?.alert(message) {
                okButton { }
            }?.show()
        }
    }

    fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when {
            event.action == KeyEvent.ACTION_DOWN -> if (keyCode == KeyEvent.KEYCODE_ESCAPE || keyCode == KeyEvent.KEYCODE_BACK) {
                onBack()
                return true
            }
        }
        return false
    }

    open fun onBack() {}
}