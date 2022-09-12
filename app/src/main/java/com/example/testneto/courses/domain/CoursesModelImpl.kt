package com.example.testneto.courses.domain

import com.example.testneto.courses.data.entity.NetworkModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoursesModelImpl @Inject constructor(
  private val scope: CoroutineScope,
  private val repository: CoursesRepository,
) : CoursesModel {

  data class ViewState(
    val data: NetworkModel? = null,
  )

  private val _viewState = MutableStateFlow(ViewState())

  override val data: Flow<NetworkModel?> = repository.getAllData()

  override fun fetchData() {
    scope.launch {
      val data = repository.fetch()
      _viewState.update { state ->
        state.copy(
          data = data
        )
      }
    }
  }
}