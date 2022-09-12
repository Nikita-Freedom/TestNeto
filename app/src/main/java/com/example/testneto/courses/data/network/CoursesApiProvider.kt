package com.example.testneto.courses.data.network

import javax.inject.Inject

class CoursesApiProvider @Inject constructor(
  private val coursesApi: CoursesApi,
) {
  suspend fun getData() = coursesApi.getDataApi()
}
