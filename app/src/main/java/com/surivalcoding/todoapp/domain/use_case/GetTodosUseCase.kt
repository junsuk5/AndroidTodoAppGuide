package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodosUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(): List<Todo> {
        return todoRepository.getTodos()
    }
}