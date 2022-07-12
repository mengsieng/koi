package ig.core.android.service.repository

import android.annotation.SuppressLint
import androidx.databinding.BaseObservable
import ig.core.android.service.model.LoginRequestTest
import ig.core.android.service.model.LoginResponse
import ig.core.android.webservice.WebService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginRepository : BaseObservable() {

    private var mLoginRequestCallback: LoginRequestCallback? = null

    @SuppressLint("CheckResult")
    fun loginRequest(loginRequestCallback: LoginRequestCallback, loginRequestTest: LoginRequestTest) {

        mLoginRequestCallback = loginRequestCallback

        WebService.requestLocal().loginRequestTest(loginRequestTest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onLoginResponseSuccess(it)
                }, {
                    onLoginResponseError(it)
                })
    }

    interface LoginRequestCallback {
        fun onLoginResponseSuccess(loginResponse: LoginResponse)
        fun onLoginResponseError(errorMessage: Throwable)
    }

    private fun onLoginResponseSuccess(loginResponse: LoginResponse) {
        mLoginRequestCallback?.onLoginResponseSuccess(loginResponse)
    }

    private fun onLoginResponseError(errorMessage: Throwable) {
        mLoginRequestCallback?.onLoginResponseError(errorMessage)
    }
}
