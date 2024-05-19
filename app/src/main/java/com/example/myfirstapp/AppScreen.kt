package com.example.myfirstapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppScreen(appViewModel: AppViewModel = viewModel()) {
    val appUiState by appViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = appUiState.currentTextShow,
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = TextStyle(fontSize = 24.sp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp),
            horizontalArrangement = Arrangement.Center,
        )
        {
            Button(onClick = {
                appViewModel.updateChar(i = -1)
            },
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f),
                shape = RectangleShape,
                border = BorderStroke(5.dp,Color.Black)
            ) {
                Text(text = "<")
            }

            Button(onClick = {
                appViewModel.updateText(appUiState.currentCharShow)
            },
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f),
                shape = RectangleShape,
                border = BorderStroke(5.dp,Color.Black)
            ) {
                Text(text = appUiState.currentCharShow)
            }

            Button(onClick = {
                appViewModel.updateChar(i = 1)
            },
                modifier = Modifier
                    .height(100.dp)
                    .weight(1f),
                shape = RectangleShape,
                border = BorderStroke(5.dp,Color.Black)
            ) {
                Text(text = ">")
            }
        }
    }
}
