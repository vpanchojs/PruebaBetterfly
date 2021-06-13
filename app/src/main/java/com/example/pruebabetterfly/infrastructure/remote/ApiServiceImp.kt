package com.example.pruebabetterfly.infrastructure.remote

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiServiceImp @Inject constructor() {
    fun<Api> build(api:Class<Api>,context: Context, baseUrl:String): Api {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }
}