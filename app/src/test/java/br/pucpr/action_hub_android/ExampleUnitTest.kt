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
import kotlin.random.Random

class ExampleUnitTest {
    private lateinit var taskRepository: TaskRepository

    @Before
    fun setup() {
        taskRepository = TaskRepositoryImpl()
    }

    @Test
    fun testAddAndGetTask() {
        for (i in 1..20) {
            val task = Task(id = i, title = "Task-$i", description = "Desc-$i")
            taskRepository.addTask(task)
        }
        val myRandom = Random.nextInt(1, 21)
        val findTask = taskRepository.getTaskById(myRandom)

        assertNotNull(findTask)
        assertEquals(myRandom, findTask?.id)
        assertEquals("Task-$myRandom", findTask?.title)
        assertEquals("Desc-$myRandom", findTask?.description)
    }

}
