package com.example.testneto.courses.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class DataNM(
  @Json(name = "groups")
  val groups: List<GroupNM>,

  @Json(name = "direction")
  val direction: DirectionNM
)