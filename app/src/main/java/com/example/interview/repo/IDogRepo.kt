package com.example.interview.repo

import com.example.interview.model.Dog
import kotlinx.coroutines.flow.Flow

interface IDogRepo {

    fun getDogInfo() : Flow<Dog>
}