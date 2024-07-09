package com.surivalcoding.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.presentation.TodoScreen
import com.surivalcoding.todoapp.presentation.TodoViewModel
import com.surivalcoding.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: TodoViewModel = viewModel(
                factory = TodoViewModel.provideFactory()
            )
            val uiState by viewModel.uiState.collectAsState()
            TodoAppTheme {
                TodoScreen(
                    uiState = uiState,
                    onAddItem = {
                        viewModel.addTodo(mockTodos.random())
                    }
                )
            }
        }
    }
}

val mockTodos = listOf(
    Todo(1, "우유 구매"),
    Todo(2, "이메일 확인"),
    Todo(3, "운동 30분"),
    Todo(4, "보고서 작성"),
    Todo(5, "책 읽기"),
    Todo(6, "병원 예약"),
    Todo(7, "집안 청소"),
    Todo(8, "친구와 저녁 약속"),
    Todo(9, "프로젝트 계획 수립"),
    Todo(10, "식료품 쇼핑"),
    Todo(11, "부모님께 전화"),
    Todo(12, "영어 공부"),
    Todo(13, "차량 정기 점검"),
    Todo(14, "화분에 물 주기"),
    Todo(15, "명상하기"),
)