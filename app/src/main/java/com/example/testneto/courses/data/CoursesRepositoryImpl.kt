package com.example.testneto.courses.data

import com.example.testneto.courses.data.network.CoursesApiProvider
import com.example.testneto.courses.data.entity.DataNM
import com.example.testneto.courses.data.entity.NetworkModel
import com.example.testneto.courses.domain.CoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import retrofit2.Response
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


//  override suspend fun orders(): DataNM {
//    val url = "netology.json"
//    return ordersApiProvider.getData(url = url)
//  }


//    @OptIn(ExperimentalCoroutinesApi::class)
//    override suspend fun orders(): MutableList<Course> = suspendCancellableCoroutine { continuation ->
//            try {
//                val collection = firestore.collection("tasks")
//                collection
//                    .get()
//                    .addOnSuccessListener { result ->
//                        val orders = mutableListOf<Course>()
//                        for (document in result) {
//                            val order = document.toObject<Course>()
//                            orders.add(order)
//                            _orders.tryEmit(orders)
//                        }
//                        continuation.resume(orders, onCancellation = null)
//                    }.addOnFailureListener {
//                        continuation.resumeWithException(it)
//                    }
//            } catch (e: Exception) {
//                continuation.resumeWithException(e)
//            }
//        }
}
