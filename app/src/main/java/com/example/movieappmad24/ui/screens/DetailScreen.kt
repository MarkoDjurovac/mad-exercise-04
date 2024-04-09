package com.example.movieappmad24.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.ui.widgets.HorizontalScrollableImageView
import com.example.movieappmad24.ui.widgets.MoviePlayer
import com.example.movieappmad24.ui.widgets.MovieRow
import com.example.movieappmad24.ui.widgets.SimpleTopAppBar
import com.example.movieappmad24.viewmodels.MoviesViewModel

@Composable
fun DetailScreen(
    movieId: String?,
    navController: NavController,
    moviesViewModel: MoviesViewModel
) {

    movieId?.let {
        val movie = moviesViewModel.movies.filter { movie -> movie.id == movieId }[0]

        Scaffold (
            topBar = {
                SimpleTopAppBar(title = movie.title) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            }
        ){ innerPadding ->
            Column {
                MovieRow(modifier = Modifier.padding(innerPadding), movie = movie)
                Divider(modifier = Modifier.padding(3.dp))
                Text(text = "Movie Trailer")
                MoviePlayer(context = LocalContext.current)
                Divider(modifier = Modifier.padding(3.dp))
                HorizontalScrollableImageView(movie = movie)
            }
        }
    }
}