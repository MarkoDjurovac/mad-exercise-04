package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.ui.widgets.MovieList
import com.example.movieappmad24.ui.widgets.SimpleBottomAppBar
import com.example.movieappmad24.ui.widgets.SimpleTopAppBar
import com.example.movieappmad24.viewmodels.MoviesViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    moviesViewModel: MoviesViewModel
) {
    Scaffold (
        topBar = {
            SimpleTopAppBar(title = "Movie App")
        },
        bottomBar = {
            SimpleBottomAppBar(
                navController = navController
            )
        }
    ){ innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            movies = moviesViewModel.movies,
            navController = navController,
            viewModel = moviesViewModel
        )
    }
}