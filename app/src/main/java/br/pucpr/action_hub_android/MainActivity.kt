package br.pucpr.action_hub_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.pucpr.action_hub_android.presentation.ui.AddTaskScreen
import br.pucpr.action_hub_android.presentation.ui.TaskDetailsScreen
import br.pucpr.action_hub_android.presentation.ui.TaskListScreen
import br.pucpr.action_hub_android.ui.theme.Action_hub_androidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "task_list") {
                composable("task_list") { TaskListScreen(navController) }
                composable("add_task") { AddTaskScreen(navController) }
                composable("task_details/{taskId}") { backStackEntry ->
                    val taskId = backStackEntry.arguments?.getString("taskId")?.toInt()
                    TaskDetailsScreen(navController, taskId)
                }
            }
        }
    }
}