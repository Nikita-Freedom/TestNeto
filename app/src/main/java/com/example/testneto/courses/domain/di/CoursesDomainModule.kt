package com.example.testneto.courses.domain.di

import com.example.testneto.courses.domain.CoursesModel
import com.example.testneto.courses.domain.CoursesModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface CoursesDomainModule {
  @Binds
  @ViewModelScoped
  fun bindCoursesModel(coursesModel: CoursesModelImpl): CoursesModel
}