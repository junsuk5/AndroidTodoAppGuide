package com.surivalcoding.todoapp.domain.use_case

import com.surivalcoding.todoapp.domain.MockTodoRepository
import com.surivalcoding.todoapp.domain.model.Todo
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class GetTodosUseCaseTest {
    private lateinit var getTodosUseCase: GetTodosUseCase

    @Before
    fun setUp() {
        // given
        val todoRepository = MockTodoRepository(
            todos = mutableListOf(
                Todo(3, "Buy bread"),
                Todo(1, "Buy milk"),
                Todo(2, "Buy eggs"),
            )
        )
        getTodosUseCase = GetTodosUseCase(todoRepository)
    }

    @Test
    fun `getTodos() 는 id로 오름차순 정렬된 객체를 리턴해야 한다`() {
        // when
        val todos = getTodosUseCase()
        assertEquals(3, todos.size)

        // then
        assertEquals(1, todos[0].id)
        assertEquals(2, todos[1].id)
        assertEquals(3, todos[2].id)
    }
}

