package ig.core.android.util

import android.content.Context
import android.content.SharedPreferences

object PrefModule {
    val instance = SharePreferenceService()
}

class SharePreferenceService{

    private val prefFileName = "app_pref"

    /// Pref name
    private val languageKey = "LANGUAGE_KEY"

    private lateinit var pref: SharedPreferences

    fun startPref(context: Context){
        pref = context.getSharedPreferences("app_name", 0)
    }

    var language: String
        get() = pref.getString(languageKey, "en")!!
        set(value) = pref.edit().putString(languageKey, value).apply()

}