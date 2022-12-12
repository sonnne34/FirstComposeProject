package com.sonne.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.sonne.firstcomposeproject.ui.CatgramProfileCard
import com.sonne.firstcomposeproject.ui.MainViewModel
import com.sonne.firstcomposeproject.ui.theme.FirstComposeProjectTheme

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
                    items(models.value) { model ->
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

