package com.surivalcoding.todoapp.data.repository

import com.surivalcoding.todoapp.data.data_source.TodoDataSource
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {

    override fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override fun insertTodo(todo: Todo) {
        todoDataSource.addTodo(todo)
    }

    override fun deleteTodo(id: Int) {
        todoDataSource.deleteTodo(id)
    }

    override fun updateTodo(todo: Todo) {
        todoDataSource.updateTodo(todo)
    }
}