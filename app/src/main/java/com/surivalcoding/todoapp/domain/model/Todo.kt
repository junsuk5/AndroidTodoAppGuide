package com.surivalcoding.todoapp.domain.model

data class Todo(
    val id: Int,
    val title: String = "",
    val completed: Boolean = false,
)
