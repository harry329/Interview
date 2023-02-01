package com.example.interview.network

import com.example.interview.model.Dog
import retrofit2.http.GET

interface DogService {

    @GET("image/random")
    suspend fun getDogBreeds() : Dog
}