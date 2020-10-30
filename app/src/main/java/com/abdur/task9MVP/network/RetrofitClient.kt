package com.abdur.task9MVP.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val JSON_BASE_URL = "https://raw.githubusercontent.com/"

    private val gsonBuilding = GsonBuilder().create()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(JSON_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gsonBuilding))
        .build()

    fun getClient(): Retrofit {
        return retrofitClient
    }
}