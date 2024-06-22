package com.surivalcoding.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.todoapp.data.repository.TodoRepositoryImpl
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository
import com.surivalcoding.todoapp.domain.use_case.AddTodoUseCase
import com.surivalcoding.todoapp.domain.use_case.GetTodosUseCase
import com.surivalcoding.todoapp.presentation.TodoScreen
import com.surivalcoding.todoapp.presentation.TodoViewModel
import com.surivalcoding.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: TodoViewModel = viewModel(
                factory = TodoViewModel.provideFactory()
            )
            val uiState by viewModel.uiState.collectAsState()
            TodoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        uiState = uiState,
                        onAddItem = {
                            viewModel.addTodo(mockTodos.random())
                        }
                    )
                }
            }
        }
    }
}

val mockTodos = listOf(
    Todo(1, "test1"),
    Todo(2, "test2"),
    Todo(3, "test3"),
    Todo(4, "청소"),
    Todo(5, "청소"),
    Todo(6, "청소"),
    Todo(7, "청소"),
    Todo(8, "청소"),
    Todo(9, "청소"),
    Todo(10, "청소"),
    Todo(11, "청소"),
    Todo(12, "청소"),
    Todo(13, "청소"),
    Todo(14, "청소"),
    Todo(15, "청소"),
)