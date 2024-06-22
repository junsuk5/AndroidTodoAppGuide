package com.surivalcoding.todoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.surivalcoding.todoapp.TodoApplication
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.use_case.AddTodoUseCase
import com.surivalcoding.todoapp.domain.use_case.GetTodosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel(
    private val addTodoUseCase: AddTodoUseCase,
    private val getTodosUseCase: GetTodosUseCase,
) : ViewModel() {

    private var _uiState = MutableStateFlow(TodoUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(todos = getTodosUseCase())
        }
    }

    fun addTodo(todo: Todo) {
        addTodoUseCase.invoke(todo)
        _uiState.update {
            it.copy(todos = getTodosUseCase())
        }
    }

    companion object {
        fun provideFactory(): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TodoApplication)
                TodoViewModel(
                    application.addTodoUseCase,
                    application.getTodosUseCase,
                )
            }
        }
    }
}

data class TodoUiState(
    val todos: List<Todo> = emptyList()
)