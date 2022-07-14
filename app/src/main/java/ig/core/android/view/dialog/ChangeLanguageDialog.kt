package ig.core.android.view.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import ig.core.android.R
import ig.core.android.util.PrefModule
import kotlinx.android.synthetic.main.dialog_change_language.*

class ChangeLanguageDialog(
    val onOkClick: (code: String) -> Unit
): DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }
        return inflater.inflate(R.layout.dialog_change_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when(PrefModule.instance.language){
            "km" -> {
                kh_tick.visibility = View.VISIBLE
            }
            "zh" -> {
                zh_tick.visibility = View.VISIBLE
            }
            "en" -> {
                en_tick.visibility = View.VISIBLE
            }
            else -> {
                en_tick.visibility = View.VISIBLE
            }
        }
        khLang.setOnClickListener {
            PrefModule.instance.language = "km"
            onLanguageSelectChange(kh_tick)
        }
        chLang.setOnClickListener {
            PrefModule.instance.language = "zh"
            onLanguageSelectChange(zh_tick)
        }
        enLang.setOnClickListener {
            PrefModule.instance.language = "en"
            onLanguageSelectChange(en_tick)
        }
        btn_ok.setOnClickListener {
            this.onOkClick(PrefModule.instance.language)
            dismiss()
        }
    }

    private fun onLanguageSelectChange(changeView: View){
        kh_tick.visibility = View.INVISIBLE
        zh_tick.visibility = View.INVISIBLE
        en_tick.visibility = View.INVISIBLE
        changeView.visibility = View.VISIBLE
    }

}