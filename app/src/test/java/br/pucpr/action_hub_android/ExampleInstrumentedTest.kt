package br.pucpr.action_hub_android

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.pucpr.action_hub_android.data.model.Task
import br.pucpr.action_hub_android.data.repository.TaskRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @JvmField
    @Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var taskRepository: TaskRepository

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testAddAndGetTask() {
        val task = Task(id = 1, title = "Test Task", description = "Test Description")
        taskRepository.addTask(task)

        val retrievedTask = taskRepository.getTaskById(1)
        Assert.assertNotNull(retrievedTask)
        Assert.assertEquals("Test Task", retrievedTask?.title)
    }
}
