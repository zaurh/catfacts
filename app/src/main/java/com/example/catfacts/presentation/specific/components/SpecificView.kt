package com.example.catfacts.presentation.specific.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.catfacts.presentation.specific.SpecificViewModel

@Composable
fun SpecificView(
    viewModel: SpecificViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize().padding(10.dp))
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.specific?.let {
                Text(text = it.id.toString())
                Text(text = it.body)
            }
        }
    }
}