package com.example.testneto.courses.domain

import com.example.testneto.courses.data.entity.NetworkModel
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
  fun getAllData(): Flow<NetworkModel>
  suspend fun fetch(): NetworkModel
}
