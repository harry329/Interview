package com.example.interview.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkClient {

    fun getRetrofit() : Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getDogService() : DogService {
        return getRetrofit().create(DogService::class.java)
    }
}