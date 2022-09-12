package com.example.testneto.courses.data.network

import com.example.testneto.courses.data.CoursesRepositoryImpl
import com.example.testneto.courses.data.network.CoursesApi
import com.example.testneto.courses.domain.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface CoursesDataModule {
  @Binds
  @ViewModelScoped
  fun bindCourseRepository(repository: CoursesRepositoryImpl): CoursesRepository
}
