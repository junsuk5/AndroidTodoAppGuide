package com.surivalcoding.todoapp.domain.repository

import com.surivalcoding.todoapp.domain.model.Todo

interface TodoRepository {
    fun getTodos(): List<Todo>
    fun insertTodo(todo: Todo)
    fun deleteTodo(id: Int)
    fun updateTodo(todo: Todo)
}