package com.surivalcoding.todoapp.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.surivalcoding.todoapp.domain.model.Todo
import com.surivalcoding.todoapp.ui.theme.TodoAppTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class TodoScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun todoScreen() {
        var count = 0

        composeTestRule.setContent {
            TodoAppTheme {
                TodoScreen(
                    uiState = TodoUiState(
                        todos = listOf(
                            Todo(1, "청소", false),
                            Todo(2, "빨래", true),
                            Todo(3, "숙제", false),
                        )
                    ),
                    onAddItem = {
                        count++
                    }
                )
            }
        }

        composeTestRule.onNodeWithText("1 : 청소").assertIsDisplayed()
        composeTestRule.onNodeWithText("2 : 빨래").assertIsDisplayed()
        composeTestRule.onNodeWithText("3 : 숙제").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Add").performClick()
        assertEquals(1, count)

        composeTestRule.onNodeWithContentDescription("Add").performClick()
        assertEquals(2, count)
    }
}