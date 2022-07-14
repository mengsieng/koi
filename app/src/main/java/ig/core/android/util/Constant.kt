package ig.core.android.util

import com.google.gson.Gson
import java.io.Reader

/****
 *
 * Created by ORN TONY on 1/16/18.
 *
 */

object Constant {
    const val USERNAME = "username"
    const val PASSWORD = "password"

    const val CORE_ANDROID = "ig.core.android"

    const val STARTACTIVITYANIM_LEFT = 1
    const val STARTACTIVITYANIM_RIGHT = 2
    const val STARTACTIVITYANIM_TOP = 3

    fun <T> errorResponse(json: Reader, clazz: Class<T>): T {
        return Gson().fromJson(json, clazz)
    }
}