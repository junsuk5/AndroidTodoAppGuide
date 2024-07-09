package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class GetTodosUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(): List<Todo> {
        // TODO : 사장님 요구 사항 추가, id 순으로 정렬
        return todoRepository.getTodos()
    }
}