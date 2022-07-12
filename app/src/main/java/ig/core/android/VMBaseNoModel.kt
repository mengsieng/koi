package ig.core.android

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BaseObservable
import androidx.lifecycle.ViewModel
import ig.core.android.util.LoadingView
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

open class VMBaseNoModel: ViewModel() {
    private var mProgressDialog: ProgressDialog? = null

    override fun equals(other: Any?): Boolean {
        return other is VMBase<*> && other.hashCode() == this.hashCode()
    }

    fun onCloseKeyboard(view: View) {
        val imm = view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private val mLoadingViewParent: ViewGroup? = null
    private var loadingView: LoadingView? = null

    open fun showLoading(context: Context, alpha: Float? = 0.3f) {
        loadingView = loadingView ?: LoadingView(context).show(context as Activity, alpha, mLoadingViewParent)
    }

    open fun hideLoading() {
        loadingView?.let{
            it.hide()
            loadingView = null
        }
    }

    protected fun onAlertError(context: Context, message: String = "Error message") {
        context.alert(message) {
            okButton { }
        }.show()
    }

    protected fun showProgressDialog(context: Context) {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(context)
            mProgressDialog!!.setCanceledOnTouchOutside(false)
            mProgressDialog!!.setCancelable(false)
        }
        mProgressDialog!!.setMessage("Processing ....")
        if (!mProgressDialog!!.isShowing) {
            mProgressDialog!!.show()
        }
    }
    protected fun hideProgressDialog() {
        mProgressDialog!!.dismiss()
    }

    override fun hashCode(): Int {
        var result = mProgressDialog?.hashCode() ?: 0
        result = 31 * result + (mLoadingViewParent?.hashCode() ?: 0)
        result = 31 * result + (loadingView?.hashCode() ?: 0)
        return result
    }
}