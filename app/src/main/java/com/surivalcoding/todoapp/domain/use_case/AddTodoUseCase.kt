package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class AddTodoUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(todo: Todo) {
        todoRepository.insertTodo(todo)
    }
}