package com.example.catfacts.presentation.list.components

import android.widget.ListView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.catfacts.presentation.list.ListViewModel

@Composable
fun ListView(
    listViewModel: ListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = listViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn{
            items(state.posts){ post ->
                ListItem(posts = post, navController)

            }
        }
    }
    
}