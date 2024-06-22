package com.surivalcoding.todoapp.data.data_source

import com.surivalcoding.todoapp.domain.model.Todo

class TodoDataSource {
    private var _todos: MutableList<Todo> = mutableListOf(
        Todo(1, "Buy milk"),
        Todo(2, "Buy eggs"),
        Todo(3, "Buy bread")
    )

    fun getTodos(): List<Todo> = _todos.toList()

    fun addTodo(todo: Todo) {
        _todos.add(todo)
    }

    fun deleteTodo(id: Int) {
        _todos.removeIf { it.id == id }
    }

    fun updateTodo(todo: Todo) {
        _todos.replaceAll { if (it.id == todo.id) todo else it }
    }
}