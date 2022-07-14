package ig.core.android.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import android.view.View
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tuonbondol.networkutil.isNetworkConnected
import ig.core.android.R
import ig.core.android.VMBaseNoModel
import ig.core.android.service.model.*
import ig.core.android.service.model.custom.ErrorResponse
import ig.core.android.service.model.custom.NetworkResponse
import ig.core.android.util.Constant
import ig.core.android.view.ui.activity.login.LoginActivity
import ig.core.android.webservice.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/****
 *
 * Created by ORN TONY on 11/18/17.
 *
 */

class LoginViewModel() : VMBaseNoModel() {
}
