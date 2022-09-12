package com.example.testneto.courses.ui

import androidx.lifecycle.viewModelScope
import com.example.testneto.core.BaseViewModel
import com.example.testneto.core.Reducer
import com.example.testneto.courses.domain.CoursesModel
import com.example.testneto.courses.ui.CoursesState.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoursesPresenter @Inject constructor(
  private val coursesModel: CoursesModel,
  dispatcher: CoroutineDispatcher,
) : BaseViewModel<ViewState, CoursesState.MainScreenUiEvent>() {

  private val reducer = MainReducer(ViewState.initial())

  override val state: Flow<ViewState>
    get() = reducer.state

  init {
    coursesModel.fetchData()
    viewModelScope.launch(dispatcher) {
      coursesModel.data.collect {
        sendEvent(CoursesState.MainScreenUiEvent.ShowData(it))
      }
    }
  }

  private fun sendEvent(event: CoursesState.MainScreenUiEvent) {
    reducer.sendEvent(event)
  }

  private class MainReducer(initial: ViewState) :
    Reducer<ViewState, CoursesState.MainScreenUiEvent>(initial) {
    override fun reduce(oldState: ViewState, event: CoursesState.MainScreenUiEvent) {
      when (event) {
        is CoursesState.MainScreenUiEvent.ShowData -> {
          setState(oldState.copy(isShowProgress = false, data = event.items))
        }
      }
    }
  }
}