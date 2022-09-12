package com.example.testneto.courses.data.entity

import com.squareup.moshi.Json

data class BadgeNM(
  @Json(name = "text")
  val text: String,

  @Json(name = "color")
  @HexColor val color: String,

  @Json(name = "bgColor")
  @HexColor val bgColor: String
)