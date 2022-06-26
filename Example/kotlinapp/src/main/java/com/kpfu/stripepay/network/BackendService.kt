package com.kpfu.stripepay.network

import com.kpfu.stripepay.model.ConnectionToken
import com.kpfu.stripepay.model.PaymentIntentCreationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackendService {
    
    @POST("connection_token")
    fun getConnectionToken(): Call<ConnectionToken>
    
    @FormUrlEncoded
    @POST("capture_payment_intent")
    fun capturePaymentIntent(@Field("payment_intent_id") id: String): Call<Void>
    
    @FormUrlEncoded
    @POST("create_payment_intent")
    fun createPaymentIntent(@Field("amount") amount: Long, @Field("currency") currency: String): Call<PaymentIntentCreationResponse>
}
