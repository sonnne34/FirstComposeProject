package com.sonne.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.sonne.firstcomposeproject.ui.MainViewModel
import com.sonne.firstcomposeproject.ui.ScaffoldTest
import com.sonne.firstcomposeproject.ui.theme.FirstComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            FirstComposeProjectTheme {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .fillMaxSize()
                ) {
                    ScaffoldTest(viewModel)
                }
            }
        }
    }
}

