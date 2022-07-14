package ig.core.android.util

import android.content.Context
import android.content.res.Configuration
import java.util.*

class ChangeLanguage {
    companion object {
        val instance = ChangeLanguage()
    }

    fun setLanguage(context: Context) {
        val locale = Locale(PrefModule.instance.language)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}
