package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository

class AddTodoUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(todo: Todo) {
        // TODO : 사장님 요구 사항 : 중복인 것은 넣지 말 것
        if (todoRepository.getTodos().any { it.id == todo.id }) return

        todoRepository.insertTodo(todo)
    }
}