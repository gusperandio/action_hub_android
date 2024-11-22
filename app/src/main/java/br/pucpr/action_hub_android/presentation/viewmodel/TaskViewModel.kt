package br.pucpr.action_hub_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pucpr.action_hub_android.data.model.Task
import br.pucpr.action_hub_android.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    fun loadTasks() {
        _tasks.value = repository.getTasks()
    }

    fun addTask(task: Task) {
        repository.addTask(task)
        loadTasks()
    }

    fun getLastId() = repository.getAutoIncrement()

    fun getTaskDetails(id: Int): Task? = repository.getTaskById(id)
}