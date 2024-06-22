package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class UpdateTodoUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(todo: Todo) {
        todoRepository.updateTodo(todo)
    }
}