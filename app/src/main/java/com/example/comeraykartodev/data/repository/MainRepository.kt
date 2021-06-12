package com.example.comeraykartodev.data.repository

import com.example.comeraykartodev.data.api.RetrofitBuilder

class MainRepository {
    suspend fun getUsers() = RetrofitBuilder.api.getUsers()
}