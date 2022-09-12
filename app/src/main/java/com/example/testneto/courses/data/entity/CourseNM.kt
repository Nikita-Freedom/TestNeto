package com.example.testneto.courses.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class CourseNM(
  @Json(name = "id")
  val id: String,
  @Json(name = "link")
  val link: String,
  @Json(name = "badge")
  val badge: BadgeNM,
  @Json(name = "title")
  val title: String,
)