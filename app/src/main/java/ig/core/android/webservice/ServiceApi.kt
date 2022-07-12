package ig.core.android.webservice

import ig.core.android.service.model.*
import ig.core.android.service.model.custom.ErrorResponse
import ig.core.android.service.model.custom.NetworkResponse
import io.reactivex.Observable
import retrofit2.http.*

/****
 *
 * Created by ORN TONY on 11/18/17.
 *
 */

interface ServiceApi {
    @POST("instance-order/auth/login")
    suspend fun loginRequest(@Body loginBody: LoginRequestBody): NetworkResponse<LoginResponse, ErrorResponse>

    @POST("/login")
    fun loginRequestTest(@Body loginRequestTest: LoginRequestTest): Observable<LoginResponse>
}