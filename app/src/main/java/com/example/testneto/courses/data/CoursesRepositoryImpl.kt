package com.example.testneto.courses.data

import com.example.testneto.courses.data.entity.NetworkModel
import com.example.testneto.courses.data.network.CoursesApiProvider
import com.example.testneto.courses.domain.CoursesRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class CoursesRepositoryImpl @Inject constructor(
  private val ordersApiProvider: CoursesApiProvider,
) : CoursesRepository {

  override fun getAllData(): Flow<NetworkModel> = flow {
    val data = ordersApiProvider.getData()
    emit(data)
  }.flowOn(IO)

  override suspend fun fetch(): NetworkModel {
    return ordersApiProvider.getData()
  }
}