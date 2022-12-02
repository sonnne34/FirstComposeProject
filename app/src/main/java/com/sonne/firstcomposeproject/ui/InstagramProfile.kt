package com.sonne.firstcomposeproject.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InstagramProfileCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .size(50.dp)
        )
        TooBoxes()
        TooBoxes()
        TooBoxes()
    }
}

@Composable
private fun TooBoxes() {
    Column(
        modifier = Modifier.background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .size(25.dp)
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(25.dp)
        )
    }
}