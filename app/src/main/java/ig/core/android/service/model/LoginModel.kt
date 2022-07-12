package ig.core.android.service.model

import org.json.JSONObject

data class LoginRequestBody(val email: String? = "", val password: String? = "", val imei: String? = "")

data class LoginResponse (
        val data: DataLogin,
        val success: Boolean,
        val response: ResponseLogin,
        val message: String
)

data class DataLogin (
        val accessToken: String,
        val tokenType: String
)

data class ResponseLogin (
        val code: Int,
        val message: String
)

data class LoginRequestTest(val loginRequest: JSONObject?= null)