package ig.core.android.view.ui.activity.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jaeger.library.StatusBarUtil
import ig.core.android.BaseActivity
import ig.core.android.R
import ig.core.android.view.ui.activity.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        backBtn.setOnClickListener {
            finish()
        }
        registerBtn.setOnClickListener {
            startNewActivityTop(SignupActivity::class.java, true)
        }
    }
}
