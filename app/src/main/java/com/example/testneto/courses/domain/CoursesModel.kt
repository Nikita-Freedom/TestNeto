package com.example.testneto.courses.domain

import com.example.testneto.courses.data.entity.NetworkModel
import kotlinx.coroutines.flow.Flow

interface CoursesModel {
  fun fetchData()
  val data: Flow<NetworkModel?>
}