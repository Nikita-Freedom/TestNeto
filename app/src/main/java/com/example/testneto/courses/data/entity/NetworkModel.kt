package com.example.testneto.courses.data.entity

import com.squareup.moshi.Json

data class NetworkModel(
  @Json(name = "data")
  val data: List<DataNM>,
)