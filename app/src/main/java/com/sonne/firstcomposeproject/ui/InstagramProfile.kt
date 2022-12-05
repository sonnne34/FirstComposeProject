package com.sonne.firstcomposeproject.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonne.firstcomposeproject.ui.theme.FirstComposeProjectTheme


@Composable
fun InstagramProfileCard() {
    Card(
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
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

@Preview
@Composable
fun PreviewCardLight() {
    FirstComposeProjectTheme(
        darkTheme = false
    ) {
        InstagramProfileCard()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    FirstComposeProjectTheme(
        darkTheme = true
    ) {
        InstagramProfileCard()
    }
}