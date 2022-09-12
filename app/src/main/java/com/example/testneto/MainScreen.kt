package com.example.testneto

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testneto.navigation.Route
import com.example.testneto.courses.ui.CoursesPresenter
import com.example.testneto.courses.ui.CoursesController
import com.example.testneto.ui.theme.TestNetoTheme

@Composable
fun MainScreen() {
  val navController = rememberNavController()
  TestNetoTheme {
    Scaffold(
      content = {
        NavHost(navController = navController, startDestination = Route.MainScreen) {
          mainScreenRoute()
        }
      }
    )
  }
}

private fun NavGraphBuilder.mainScreenRoute() {
  composable(Route.MainScreen) {
    val viewModel = hiltViewModel<CoursesPresenter>()
    CoursesController(viewModel = viewModel)
  }
}
