package br.pucpr.action_hub_android

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.pucpr.action_hub_android.data.model.Task
import br.pucpr.action_hub_android.data.repository.TaskRepository
import br.pucpr.action_hub_android.data.repository.TaskRepositoryImpl
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    private lateinit var taskRepository: TaskRepository

    @Before
    fun setup() {
        // Manual instance for a unit test
        taskRepository = TaskRepositoryImpl()
    }

    @Test
    fun testAddAndGetTask() {
        val task = Task(id = 1, title = "Test Task", description = "Test Description")
        taskRepository.addTask(task)

        val retrievedTask = taskRepository.getTaskById(1)
        assertNotNull(retrievedTask)
        assertEquals("Test Task", retrievedTask?.title)
    }
}
