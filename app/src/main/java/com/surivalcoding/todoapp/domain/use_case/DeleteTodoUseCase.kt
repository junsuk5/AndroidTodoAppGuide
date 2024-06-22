package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.repository.TodoRepository

class DeleteTodoUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(id: Int) = todoRepository.deleteTodo(id)
}