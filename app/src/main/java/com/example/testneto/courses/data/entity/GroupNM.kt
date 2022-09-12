package com.example.testneto.courses.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class GroupNM(
  @Json(name = "id")
  val id: String,

  @Json(name = "link")
  val link: String,

  @Json(name = "badge")
  val badge: BadgeNM,

  @Json(name = "items")
  val items: List<CourseNM>,

  @Json(name = "title")
  val title: String,
)