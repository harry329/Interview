package com.example.interview.di

import org.koin.core.module.dsl.singleOf
import  com.example.interview.vm.Screen2VM
import  com.example.interview.repo.DogRepo

import org.koin.dsl.module

val appModule = module {
    singleOf(::Screen2VM)
    singleOf(::DogRepo)
}