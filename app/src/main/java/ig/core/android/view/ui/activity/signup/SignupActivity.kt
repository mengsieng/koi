package ig.core.android.view.ui.activity.signup

import android.os.Bundle
import ig.core.android.BaseActivity
import ig.core.android.R
import ig.core.android.util.Constant
import ig.core.android.view.ui.activity.login.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        backBtn.setOnClickListener {
            finish()
        }
        loginBtn.setOnClickListener {
            startNewActivityTop(LoginActivity::class.java,true)
        }
    }

}