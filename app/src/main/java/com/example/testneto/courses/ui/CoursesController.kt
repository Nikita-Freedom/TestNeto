package com.example.testneto.courses.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testneto.courses.data.entity.*
import com.example.testneto.courses.ui.mappers.getColor

@Composable
fun CoursesController(
  viewModel: CoursesPresenter = viewModel()
) {
  val state by viewModel.state.collectAsState(initial = CoursesState.ViewState())
  Column {
    Text(
      text = "Изучайте актуальные темы",
      modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, top = 12.dp),
      style = TextStyle(
        color = Color.Black,
        fontSize = 24.sp
      ),
      textAlign = TextAlign.Start
    )
    Divider()
    when {
      state.isShowProgress -> ContentWithProgress()
      state.data != null -> MainScreenContent(state.data)
    }
  }
}

@Composable
private fun MainScreenContent(
  data: NetworkModel?,
) {
  Box {
    if (data != null) {
      AllList(
        data = data.data
      )
    } else {
//      EmptyContentMessage(
//        imgRes = R.drawable.img_files_170,
//        title = "Данных нет",
//        description = "",
//      )
    }
  }
}

@Composable
private fun AllList(
  data: List<DataNM>,
) {
  val listState = rememberLazyListState()
  LazyColumn(
    modifier = Modifier.padding(horizontal = 8.dp),
    state = listState
  ) {
    items(items = data) { dataNM ->
      dataNM.groups.forEach { group ->
        DirectionItem(
          item = dataNM.direction
        )
        Group(
          group = group
        )
      }
    }
  }
}

@Composable
private fun Group(
  group: GroupNM,
) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    GroupItem(
      item = group
    )
    group.items.forEach { courseItem ->
      CoursesListItem(
        item = courseItem
      )
    }
  }
}


@Composable
private fun GroupItem(
  item: GroupNM,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 24.dp, start = 12.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      modifier = Modifier.weight(4f),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {
      Text(
        text = item.title,
        style = TextStyle(
          color = Color.Black,
          fontSize = 18.sp
        ),
        textAlign = TextAlign.Start
      )
      Text(
        text = item.link,
        style = TextStyle(
          color = Color.Gray,
          fontSize = 16.sp
        )
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 18.dp)
        .weight(1f)
        .wrapContentSize(Alignment.Center),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = item.badge.text,
        modifier = Modifier.padding(bottom = 4.dp),
        style = TextStyle(
          color = Color.Gray,
          fontSize = 16.sp
        )
      )
      Box(
        modifier = Modifier
          .size(40.dp)
          .clip(RectangleShape)
          .background(getColor(item.badge.bgColor))
      ) {
        Box(
          modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(getColor(item.badge.color))
            .align(Alignment.Center)
        )
      }
    }
  }
}

@Composable
private fun CoursesListItem(
  item: CourseNM,
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 6.dp),
    elevation = 10.dp
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier.weight(4f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          text = item.title,
          modifier = Modifier.padding(start = 12.dp, bottom = 4.dp),
          style = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
          ),
          textAlign = TextAlign.Start
        )
        Text(
          text = item.link,
          modifier = Modifier.padding(start = 16.dp),
          style = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp
          ),
          textAlign = TextAlign.Start
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(bottom = 18.dp)
          .weight(1f)
          .wrapContentSize(Alignment.Center)
      ) {
        Text(
          text = item.badge.text,
          modifier = Modifier.padding(start = 16.dp, bottom = 4.dp),
          style = TextStyle(
            color = Color.Gray,
            fontSize = 16.sp
          )
        )
        Box(
          modifier = Modifier
            .size(40.dp)
            .clip(RectangleShape)
            .background(getColor(item.badge.color))
        ) {
          Box(
            modifier = Modifier
              .size(30.dp)
              .clip(CircleShape)
              .background(getColor(item.badge.bgColor))
              .align(Alignment.Center)
          )
        }
      }
    }
  }
}

@Composable
private fun DirectionItem(
  item: DirectionNM,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 26.dp),
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        modifier = Modifier
          .weight(4f)
          .padding(start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          text = item.title,
          modifier = Modifier.padding(bottom = 4.dp),
          style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
          )
        )
        Text(
          text = item.link,
          modifier = Modifier.padding(bottom = 4.dp),
          style = TextStyle(
            color = Color.Gray,
            fontSize = 16.sp
          )
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .padding(bottom = 18.dp)
          .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = item.badge.text,
          modifier = Modifier.padding(start = 16.dp, bottom = 4.dp),
          style = TextStyle(
            color = Color.Gray,
            fontSize = 16.sp
          )
        )
        Box(
          modifier = Modifier
            .size(40.dp)
            .clip(RectangleShape)
            .background(getColor(item.badge.color))
        ) {
          Box(
            modifier = Modifier
              .size(30.dp)
              .clip(CircleShape)
              .background(getColor(item.badge.bgColor))
              .align(Alignment.Center)
          )
        }
      }
    }
    Divider()
  }
}


@Composable
private fun ContentWithProgress() {
  Surface(color = Color.LightGray) {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      CircularProgressIndicator()
    }
  }
}