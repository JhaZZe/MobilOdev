package com.example.comeraykartodev.data.api

import com.example.comeraykartodev.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<MutableList<User>>
}


