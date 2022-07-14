package ig.core.android.util.session

import android.annotation.SuppressLint
import android.content.Context
import ig.core.android.service.model.LoginResponse
import ig.core.android.util.Constant

class UserSession(val context: Context) : BaseSession(context) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: UserSession? = null
        fun getInstance(context: Context): UserSession {

            if (instance == null)
                instance = UserSession(context)
            return instance!!
        }
    }

    override val preferenceName: String
        get() = "user"

    fun setUsername(value: String) {
        save(Constant.USERNAME, value)
    }

    fun getUsername() : String {
        return get(Constant.USERNAME,"").toString()
    }

    fun setPassword(value: String) {
        save(Constant.PASSWORD, value)
    }

    fun getPassword() : String {
        return get(Constant.PASSWORD,"").toString()
    }

    fun mapData(data: LoginResponse) : UserSession {
        setUsername(data.message!!)
        setPassword(data.message!!)
        return this
    }

}