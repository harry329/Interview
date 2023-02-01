package com.example.interview.repo

import com.example.interview.network.NetworkClient
import kotlinx.coroutines.flow.flow

class DogRepo : IDogRepo {

    val dogService = NetworkClient().getDogService()

    override fun getDogInfo() = flow {
        emit(dogService.getDogBreeds())
    }
}