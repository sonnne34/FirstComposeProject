package com.sonne.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo(name = "Настя", age = 31)
        }
    }
}

@Composable
fun UserInfo(name: String, age: Int) {
    Text(text = "Привет, $name! Тебе $age лет.")
}