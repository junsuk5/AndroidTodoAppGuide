package com.surivalcoding.todoapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.todoapp.domain.model.Todo

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    uiState: TodoUiState = TodoUiState(),
    onAddItem: () -> Unit = {},
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn {
            items(uiState.todos.size) { index ->
                val todo = uiState.todos[index]
                Text("${todo.id} : ${todo.title}")
            }
        }
        FloatingActionButton(
            onClick = onAddItem,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add",
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TodoScreenPreview() {
    TodoScreen(
        uiState = TodoUiState(
            todos = listOf(
                Todo(1, "Learn Compose", false),
                Todo(2, "Learn Compose", true),
                Todo(3, "Learn Compose", false),
            )
        )
    )
}