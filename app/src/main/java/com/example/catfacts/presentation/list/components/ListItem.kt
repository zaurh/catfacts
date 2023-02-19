package com.example.catfacts.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.catfacts.domain.model.Posts

@Composable
fun ListItem(
    posts: Posts,
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()){
        Row(Modifier.fillMaxWidth().clickable {
            navController.navigate("specific/${posts.id}")
        }) {
            Text(text = "${posts.id}. " + "${posts.title}", modifier = Modifier.padding(10.dp))
        }
    }
}