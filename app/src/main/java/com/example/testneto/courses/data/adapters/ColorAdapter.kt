package com.example.testneto.courses.data.adapters

import com.example.testneto.courses.data.entity.HexColor
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson


/** Converts string like #ff0000 to the corresponding color ints.  */
class ColorAdapter {
  @ToJson fun toJson(@HexColor rgb: Int): String {
    return "#%06x".format(rgb)
  }

  @FromJson @HexColor fun fromJson(rgb: String): Int {
    return rgb.substring(1).toInt(16)
  }
}