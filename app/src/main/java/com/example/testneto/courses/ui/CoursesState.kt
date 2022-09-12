package com.example.testneto.courses.ui

import androidx.compose.runtime.Immutable
import com.example.testneto.core.UiEvent
import com.example.testneto.core.UiState
import com.example.testneto.courses.data.entity.DataNM
import com.example.testneto.courses.data.entity.NetworkModel
import kotlinx.coroutines.flow.Flow

class CoursesState {

  @Immutable
  sealed class MainScreenUiEvent : UiEvent {
    data class ShowData(val items: NetworkModel?) : MainScreenUiEvent()
  }

  @Immutable
  data class ViewState(
    val isShowProgress: Boolean = false,
    val error: Throwable? = null,
    val data:  NetworkModel? = null
  ) : UiState {
    companion object {
      fun initial() = ViewState(
        isShowProgress = true,
        data = null,
      )
    }
  }
}