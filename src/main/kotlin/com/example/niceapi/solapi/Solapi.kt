package com.example.niceapi.solapi

import com.example.niceapi.solapi.request.SendMessageRequest
import com.example.niceapi.solapi.response.SendMessageResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Solapi {

    @POST("messages/v4/send")
    fun sendMessage(

        @Body request: SendMessageRequest
    ): Call<SendMessageResponse>
}