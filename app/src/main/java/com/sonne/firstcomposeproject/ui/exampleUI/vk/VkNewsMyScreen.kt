package com.sonne.firstcomposeproject.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyScreen() {
//    val snackBarHostState = remember {
//        SnackbarHostState()
//    }
//    val scope = rememberCoroutineScope()
//    val fabIsVisible = remember {
//        mutableStateOf(true)
//    }

//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackBarHostState)
//        },
//        floatingActionButton = {
//            if (fabIsVisible.value) {
//                FloatingActionButton(onClick = {
//                    scope.launch {
//                        val action = snackBarHostState.showSnackbar(
//                            message = "I Like it",
//                            actionLabel = "Hide",
//                            duration = SnackbarDuration.Long
//                        )
//                        if (action == SnackbarResult.ActionPerformed) {
//                            fabIsVisible.value = false
//                        }
//                    }
//                }) {
//                    Icon(Icons.Filled.Favorite, contentDescription = null)
//                }
//            }
//        },
//        bottomBar = {
//            BottomNavigation {
//                val selectedItemPosition = remember {
//                    mutableStateOf(0)
//                }
//
//                val items = listOf(
//                    NavigationItem.Home,
//                    NavigationItem.Favourite,
//                    NavigationItem.Profile
//                )
//                items.forEachIndexed { index, item ->
//                    BottomNavigationItem(
//                        selected = selectedItemPosition.value == index,
//                        onClick = { selectedItemPosition.value = index },
//                        icon = {
//                            Icon(item.icon, contentDescription = null)
//                        },
//                        label = {
//                            Text(text = stringResource(id = item.titleResId))
//                        },
//                        selectedContentColor = MaterialTheme.colors.onPrimary,
//                        unselectedContentColor = MaterialTheme.colors.onSecondary
//                    )
//                }
//            }
//        }
//    ){
//     CardPost()
//    }
}