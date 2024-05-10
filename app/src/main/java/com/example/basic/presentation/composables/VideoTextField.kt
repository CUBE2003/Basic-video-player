package com.example.basic.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VideoTextField(
    modifier: Modifier = Modifier,
    search: String,
    onTextChange: (String) -> Unit,
    onSearchClick: () -> Unit // New parameter for search icon click
) {
    OutlinedTextField(

        value = search,
        onValueChange = onTextChange,
        label = { Text(text = "Search here..") },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Adjust padding if needed
        singleLine = true,
        trailingIcon = { // Use trailingIcon for right placement
            IconButton(onClick = onSearchClick) { // Wrap in IconButton
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        }
    )
}
