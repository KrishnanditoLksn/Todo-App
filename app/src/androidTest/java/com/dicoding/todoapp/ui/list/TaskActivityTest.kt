package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4::class)
class TaskActivityTest {

    @Before
    fun setup() {
        Intents.init()
        ActivityScenario.launch(TaskActivity::class.java)
    }


    @Test
    fun whenTaskActivityDisplayed() {
        onView(withId(R.id.fab))
            .check(matches(isDisplayed()))
            .perform(click())

        Intents.intended(hasComponent(AddTaskActivity::class.java.name))
    }
}