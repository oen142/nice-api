package com.example.niceapi.solapi

import com.example.niceapi.solapi.exception.SolapiResponseException
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

class SolapiClient(
    private val appId: String,
    private val appKey: String
) {
    private val solapi: Solapi

    init {
        val client = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL(FULL_API_URL))
            .addConverterFactory(buildGsonConverter())
            .client(client)
            .build()


        solapi = retrofit.create(Solapi::class.java)
    }

    @Throws(SolapiResponseException::class, IOException::class)
    fun sendKakao(){
        val call = solapi.send()

        val response = call.execute()
    }

    private fun buildGsonConverter(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()

        val gson = gsonBuilder.create()

        return GsonConverterFactory.create(gson)
    }
    companion object {
        private const val FULL_API_URL = "https://api.solapi.com/"
    }

    private fun getExceptionMessage(response: Response<*>): String =
        try {
            val element = JsonParser().parse(response.errorBody()?.string())
            element.asJsonObject.get("message").asString
        } catch (e: JsonSyntaxException) {
            e.message.toString()
        } catch (e: IOException) {
            e.message.toString()
        }

}