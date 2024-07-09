package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.MockTodoRepository
import com.surivalcoding.todoapp.domain.model.Todo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class AddTodoUseCaseTest {
    private lateinit var addTodoUseCase: AddTodoUseCase
    private lateinit var todoRepository: MockTodoRepository

    @Before
    fun setUp() {
        todoRepository = MockTodoRepository()
        addTodoUseCase = AddTodoUseCase(todoRepository)
    }

    @Test
    fun `addTodo() 는 Todo를 추가해야 한다`() {
        // when
        var todos = todoRepository.getTodos()
        assertEquals(0, todos.size)

        // then
        val todo = Todo(1, "Buy milk")
        addTodoUseCase(todo)
        todos = todoRepository.getTodos()
        assertEquals(1, todos.size)
        assertEquals(todo, todos[0])
    }

    @Test
    fun `addTodo() 는 중복된 Todo는 추가하지 않는다`() {
        // given
        val todo = Todo(1, "Buy milk")
        todoRepository.insertTodo(todo)

        // when
        addTodoUseCase(todo)
        addTodoUseCase(todo)

        // then
        val todos = todoRepository.getTodos()
        assertEquals(1, todos.size)
    }
}