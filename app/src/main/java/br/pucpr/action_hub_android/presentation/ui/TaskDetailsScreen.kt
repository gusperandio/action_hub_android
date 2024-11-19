package br.pucpr.action_hub_android.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.pucpr.action_hub_android.presentation.viewmodel.TaskViewModel

@Composable
fun TaskDetailsScreen(navController: NavController, taskId: Int?) {
    val viewModel: TaskViewModel = hiltViewModel()
    val task = taskId?.let { viewModel.getTaskDetails(it) }

    task?.let {
        Column {
            Text("Title: ${it.title}")
            Text("Description: ${it.description}")
        }
    } ?: Text("Task not found")
}