package com.sonne.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.sonne.firstcomposeproject.ui.CatgramProfileCard
import com.sonne.firstcomposeproject.ui.MainViewModel
import com.sonne.firstcomposeproject.ui.theme.FirstComposeProjectTheme

@OptIn(ExperimentalMaterialApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            Test(viewModel)
        }
    }

    @Composable
    private fun Test(viewModel: MainViewModel) {
        FirstComposeProjectTheme {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()
            ) {
                val models = viewModel.catgram.observeAsState(listOf())
                LazyColumn {
                    items(models.value, key = { it.id }) { model ->
                        val dismissState = rememberDismissState()

                        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                            viewModel.delete(model)
                        }
                        SwipeToDismiss(
                            state = dismissState,
                            directions = setOf(DismissDirection.EndToStart),
                            background = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                        .background(Color.Red.copy(alpha = 0.5f)),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Text(
                                        modifier = Modifier.padding(16.dp),
                                        text = "Delete item",
                                        fontSize = 24.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        ) {
                            CatgramProfileCard(
                                catgramModel = model,
                                onClickFollowed = {
                                    viewModel.changeIsFollowing(it)
                                })
                        }
                    }
                }
            }
        }
    }
}

