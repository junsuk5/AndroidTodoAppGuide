package com.surivalcoding.todoapp.data.data_source

import com.surivalcoding.todoapp.domain.model.Todo

class TodoDataSource {
    private val todos: MutableList<Todo> = mutableListOf()

    fun getTodos(): List<Todo> = todos.toList()

    fun addTodo(todo: Todo) {
        todos.add(todo)
    }

    fun deleteTodo(id: Int) {
        todos.removeIf { it.id == id }
    }

    fun updateTodo(todo: Todo) {
        todos.replaceAll { if (it.id == todo.id) todo else it }
    }
}