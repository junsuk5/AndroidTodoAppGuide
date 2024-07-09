package com.surivalcoding.todoapp.data.data_source.impl

import com.surivalcoding.todoapp.data.data_source.TodoDataSource
import com.surivalcoding.todoapp.domain.model.Todo

class TodoDataSourceImpl : TodoDataSource {
    private val todos: MutableList<Todo> = mutableListOf()

    override fun getTodos(): List<Todo> = todos.toList()

    override fun addTodo(todo: Todo) {
        todos.add(todo)
    }

    override fun deleteTodo(id: Int) {
        todos.removeIf { it.id == id }
    }

    override fun updateTodo(todo: Todo) {
        todos.replaceAll { if (it.id == todo.id) todo else it }
    }
}