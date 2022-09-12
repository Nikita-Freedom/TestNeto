package com.example.testneto.courses.data.network

import com.example.testneto.courses.data.entity.NetworkModel
import retrofit2.http.GET

interface CoursesApi {
  @GET("netology.json")
  suspend fun getDataApi(): NetworkModel
}