package com.example.testneto.courses.ui.mappers

import android.graphics.Color.*
import androidx.compose.ui.graphics.Color

fun getColor(colorString: String): Color {
  return try {
    Color(parseColor(colorString))
  } catch (e: IllegalArgumentException) {
    Color(parseColor("#00BFFF"))
  }
}
