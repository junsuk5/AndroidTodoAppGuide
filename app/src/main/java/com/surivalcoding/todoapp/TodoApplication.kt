package com.surivalcoding.todoapp

import android.app.Application
import com.surivalcoding.todoapp.data.data_source.TodoDataSource
import com.surivalcoding.todoapp.data.repository.TodoRepositoryImpl
import com.surivalcoding.todoapp.domain.repository.TodoRepository
import com.surivalcoding.todoapp.domain.use_case.AddTodoUseCase
import com.surivalcoding.todoapp.domain.use_case.GetTodosUseCase

class TodoApplication : Application() {
    private val dataSource by lazy { TodoDataSource() }
    private val todoRepository: TodoRepository by lazy { TodoRepositoryImpl(dataSource) }

    val addTodoUseCase by lazy { AddTodoUseCase(todoRepository) }
    val getTodosUseCase by lazy { GetTodosUseCase(todoRepository) }
}