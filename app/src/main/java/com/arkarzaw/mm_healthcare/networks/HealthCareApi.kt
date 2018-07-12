package com.arkarzaw.mm_healthcare.networks

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface HealthCareApi {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHCInfo(
        @Field("access_token") accessToken: String) : Observable<HCInfoResponse>
}