package br.pucpr.action_hub_android.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.pucpr.action_hub_android.data.model.Task
import br.pucpr.action_hub_android.presentation.viewmodel.TaskViewModel
import kotlin.random.Random

@Composable
fun AddTaskScreen(navController: NavController) {
    val viewModel: TaskViewModel = hiltViewModel()
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
        Button(onClick = {
            viewModel.addTask(Task(Random.nextInt(), title, description))
            navController.popBackStack()
        }) {
            Text("Save Task")
        }
    }
}
