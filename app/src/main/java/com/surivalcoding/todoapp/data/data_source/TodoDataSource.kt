package com.surivalcoding.todoapp.data.data_source

import com.surivalcoding.todoapp.domain.model.Todo

interface TodoDataSource {
    fun getTodos(): List<Todo>
    fun addTodo(todo: Todo)
    fun deleteTodo(id: Int)
    fun updateTodo(todo: Todo)
}