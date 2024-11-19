package br.pucpr.action_hub_android.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.pucpr.action_hub_android.presentation.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(navController: NavController) {
    val viewModel: TaskViewModel = hiltViewModel()
    val tasks by viewModel.tasks.observeAsState(emptyList())

    LaunchedEffect(Unit) { viewModel.loadTasks() }

    Column {
        Button(onClick = { navController.navigate("add_task") }) {
            Text("Add Task")
        }
        LazyColumn {
            items(tasks) { task ->
                Text(
                    text = task.title,
                    modifier = Modifier.clickable {
                        navController.navigate("task_details/${task.id}")
                    }
                )
            }
        }
    }
}
