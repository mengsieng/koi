package ig.core.android.view.ui.activity.welcome

import android.os.Bundle
import androidx.core.content.ContextCompat
import ig.core.android.BaseActivity
import ig.core.android.R
import ig.core.android.util.ChangeLanguage
import ig.core.android.util.PrefModule
import ig.core.android.view.bottomsheet.FeedbackBottomSheet
import ig.core.android.view.dialog.ChangeLanguageDialog
import ig.core.android.view.ui.activity.login.LoginActivity
import ig.core.android.view.ui.activity.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        /// Load selected language flag
        setSelectedLanguage(PrefModule.instance.language)

        changeLanguageBtn.setOnClickListener {
            ChangeLanguageDialog { code ->
                setSelectedLanguage(code)
            }.show(supportFragmentManager, "")
        }
        signInBtn.setOnClickListener{
            startNewActivityTop(LoginActivity::class.java, false)
        }
        signUpBtn.setOnClickListener {
            startNewActivityTop(SignupActivity::class.java, false)
        }
        connectFbBtn.setOnClickListener {

        }
        tvFeedback.setOnClickListener {
            FeedbackBottomSheet().show(supportFragmentManager, "")
        }
    }

    private fun setSelectedLanguage(code: String){
        when(code){
            "km" -> {
                changeImage(R.drawable.ic_kh)
            }
            "zh" -> {
                changeImage(R.drawable.ic_china)
            }
            "en" -> {
                changeImage(R.drawable.ic_english)
            }
        }
    }

    private fun changeImage(resId: Int){
        ChangeLanguage.instance.setLanguage(this)
        reloadText()
        changeLanguageBtn.setImageDrawable(
            ContextCompat.getDrawable(this, resId)
        )
    }

    private fun reloadText(){
        tvWelcome.text = getString(R.string.welcome)
        tvDes.text = getString(R.string.welcome_desc)
        signInBtn.text = getString(R.string.sign_in)
        signUpBtn.text = getString(R.string.sign_up)
//        connectFbBtn.text = getString(R.string.connect_with_facebook)
        tvFeedback.text = getString(R.string.customer_feedback)
    }

}