package com.sonne.firstcomposeproject.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ScaffoldTest() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Catgram")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Profile",
                fontSize = 20.sp,
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Card",
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Phone",
                fontSize = 20.sp
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(Icons.Filled.Call, contentDescription = null)
                    },
                    label = {
                        Text(text = "Call")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(Icons.Filled.Email, contentDescription = null)
                    },
                    label = {
                        Text(text = "Email")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    },
                    label = {
                        Text(text = "Search")
                    }
                )
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            CatgramProfileCard()
        }
    }
}