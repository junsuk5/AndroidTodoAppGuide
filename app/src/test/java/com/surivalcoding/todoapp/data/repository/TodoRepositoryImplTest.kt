package com.surivalcoding.todoapp.data.repository

import com.surivalcoding.todoapp.data.MockTodoDataSource
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.domain.repository.TodoRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TodoRepositoryImplTest {

    private lateinit var todoRepository: TodoRepository

    @Before
    fun setUp() {
        // given
        val todoDataSource = MockTodoDataSource(
            mutableListOf(
                Todo(1, "Buy milk"),
                Todo(2, "Buy eggs"),
                Todo(3, "Buy bread"),
            )
        )
        todoRepository = TodoRepositoryImpl(todoDataSource)
    }

    @Test
    fun getTodos() {
        // when
        val todos = todoRepository.getTodos()

        // then
        assertEquals(3, todos.size)
    }

    @Test
    fun insertTodo() {
        // given
        val todo = Todo(4, "Buy cheese")

        // when
        todoRepository.insertTodo(todo)

        // then
        val todos = todoRepository.getTodos()
        assertEquals(4, todos.size)
    }

    @Test
    fun deleteTodo() {
        // when
        todoRepository.deleteTodo(2)

        // then
        val todos = todoRepository.getTodos()
        assertEquals(2, todos.size)
    }

    @Test
    fun updateTodo() {
        // when
        val todo = Todo(1, "Buy milk")
        todoRepository.updateTodo(todo)

        // then
        val todos = todoRepository.getTodos()
        assertEquals("Buy milk", todos[0].title)
    }
}

