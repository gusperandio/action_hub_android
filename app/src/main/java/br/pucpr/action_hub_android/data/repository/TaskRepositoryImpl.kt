package br.pucpr.action_hub_android.data.repository
import br.pucpr.action_hub_android.data.model.Task
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor() : TaskRepository {
    private val tasks = mutableListOf<Task>()

    override fun getTasks(): List<Task> = tasks

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun getTaskById(id: Int): Task? = tasks.find { it.id == id }
}