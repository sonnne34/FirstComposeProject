package com.sonne.firstcomposeproject.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonne.firstcomposeproject.R

@Composable
fun CatgramProfileCard(
    viewModel: MainViewModel
) {
    val isFollowed = viewModel.isFollowing.observeAsState(false)

    Card(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_categram),
                    contentDescription = "logo",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .background(Color.Magenta)
                        .padding(2.dp)
                )
                UserStatistics(title = "Posts", value = "6950")
                UserStatistics(title = "Followers", value = "560M")
                UserStatistics(title = "Following", value = "52")
            }

            Text(
                "Catgram",
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp
            )

            Text(
                "#AboutMe",
                fontSize = 14.sp
            )

            Text(
                "www.catgram.ru.lakukaracha",
                fontSize = 14.sp
            )
            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowingStatus()
            }
        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: State<Boolean>,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isFollowed.value) {
                MaterialTheme.colors.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colors.primary
            }
        )
    ) {
        val text = if (isFollowed.value) {
            "Unfollow"
        } else {
            "Follow"
        }

        Text(
            text = text
        )
    }
}


@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontFamily = FontFamily.Cursive,
                        fontSize = 26.sp
                    )
                ) {
                    append(title)
                }
            }
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                ) {
                    append(value)
                }
            }
        )
    }
}