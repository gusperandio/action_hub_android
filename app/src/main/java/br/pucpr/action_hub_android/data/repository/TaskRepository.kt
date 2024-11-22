package br.pucpr.action_hub_android.data.repository

import br.pucpr.action_hub_android.data.model.Task

interface TaskRepository {
    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun getTaskById(id: Int): Task?
    fun getAutoIncrement(): Int
}