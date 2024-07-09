package com.surivalcoding.todoapp.domain

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class MockTodoRepository(
    private val todos: MutableList<Todo> = mutableListOf()
) : TodoRepository {

    override fun getTodos(): List<Todo> = todos.toList()

    override fun insertTodo(todo: Todo) {
        todos.add(todo)
    }

    override fun deleteTodo(id: Int) {
        todos.removeIf { it.id == id }
    }

    override fun updateTodo(todo: Todo) {
        todos.replaceAll { if (it.id == todo.id) todo else it }
    }
}