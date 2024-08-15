package com.gobi.mymoviedb

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gobi.mymoviedb.repositoy.MovieRepository
import com.gobi.mymoviedb.services.RetrofitInstance
import com.gobi.mymoviedb.ui.theme.MyMovieDBTheme
import com.gobi.mymoviedb.views.components.DefaultButton
import com.gobi.mymoviedb.views.screens.Home
import com.gobi.mymoviedb.views.screens.Home.HomeViewModel
import com.gobi.mymoviedb.views.screens.Home.HomeViewModelFactory
import com.gobi.mymoviedb.views.screens.LoginScreenPreview
import com.gobi.mymoviedb.views.screens.MovieItem
import com.gobi.mymoviedb.views.viewmodels.MovieViewModel
import com.gobi.mymoviedb.views.viewmodels.MovieViewModelFactory

class MainActivity : ComponentActivity() {

  private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyMovieDBTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  val movieRepository = MovieRepository()
                  val homeViewModelFactory = HomeViewModelFactory(movieRepository = movieRepository)

                  homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]

                  Home(homeViewModel = homeViewModel)
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
   LoginScreenPreview()
}

