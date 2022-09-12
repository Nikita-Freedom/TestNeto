package com.example.testneto.courses.data.network.di

import com.example.testneto.courses.data.adapters.ColorAdapter
import com.example.testneto.courses.data.entity.BadgeNM
import com.example.testneto.courses.data.network.CoursesApi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  fun provideApi(): CoursesApi {
    val okhttp = OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
      })
      .build()

    val moshi = Moshi.Builder()
      .add(ColorAdapter())
      .build()

    val retrofit = Retrofit.Builder()
      .client(okhttp)
      .baseUrl("https://raw.githubusercontent.com/netology-code/rn-task/master/")
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .build()

    return retrofit
      .create(CoursesApi::class.java)
  }
}