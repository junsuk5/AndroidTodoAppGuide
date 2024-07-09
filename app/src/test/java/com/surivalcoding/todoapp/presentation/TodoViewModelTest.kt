package com.surivalcoding.todoapp.presentation

import com.surivalcoding.todoapp.domain.MockTodoRepository
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository
import com.surivalcoding.todoapp.domain.use_case.AddTodoUseCase
import com.surivalcoding.todoapp.domain.use_case.GetTodosUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@Suppress("NonAsciiCharacters")
class TodoViewModelTest {
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var todoRepository: TodoRepository

    @Before
    fun setUp() {
        todoRepository = MockTodoRepository()

        todoViewModel = TodoViewModel(
            addTodoUseCase = AddTodoUseCase(todoRepository),
            getTodosUseCase = GetTodosUseCase(todoRepository),
        )
    }

    @Test
    fun addTodo() = runBlocking {
        // given
        val todo = Todo(1, "Buy milk")

        // when
        todoViewModel.addTodo(todo)

        // then
        val todos = todoRepository.getTodos()
        assertEquals(1, todos.size)
        assertEquals(todo, todos[0])

        // when
        val uiState = todoViewModel.uiState.first()

        // then
        assertEquals(1, uiState.todos.size)
    }

    @Test
    fun `addTodo() 는 중복된 Todo는 추가하지 않는다`() = runBlocking{
        // given
        val todo = Todo(1, "Buy milk")
        todoRepository.insertTodo(todo)

        // when
        todoViewModel.addTodo(todo)
        todoViewModel.addTodo(todo)

        // then
        val todos = todoRepository.getTodos()
        assertEquals(1, todos.size)

        // when
        val uiState = todoViewModel.uiState.first()

        // then
        assertEquals(1, uiState.todos.size)
    }

}