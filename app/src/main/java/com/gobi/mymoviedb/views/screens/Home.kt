package com.gobi.mymoviedb.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gobi.mymoviedb.models.Movie
import com.gobi.mymoviedb.repositoy.MovieRepository
import com.gobi.mymoviedb.views.components.SimpleSurface
import com.gobi.mymoviedb.views.screens.Home.HomeViewModel
import com.gobi.mymoviedb.views.screens.Home.HomeViewModelFactory
import com.gobi.mymoviedb.views.viewmodels.MovieViewModel


@Composable
fun Home(homeViewModel: HomeViewModel = viewModel()) {

  val state by homeViewModel.state

  if (state.isLoading) {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
  } else if (state.error.isNotEmpty()) {
    Text(text = "Error: ${state.error}", modifier = Modifier.fillMaxSize())
  } else {
    LazyColumn {
      items(state.movies) { movie ->
        MovieItem(movie)
      }
    }
  }
}

@Composable
fun MovieItem(movie: Movie) {
  Row(modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp),
    horizontalArrangement = Arrangement.SpaceBetween
    ) {
    Box(modifier = Modifier.width(300.dp)){
      Text(text = movie.title, style = MaterialTheme.typography.labelLarge , fontSize = 20.sp)
    }
    Text(text = movie.release_date, style = MaterialTheme.typography.bodyMedium)
  }
}

