package br.pucpr.action_hub_android.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.pucpr.action_hub_android.R
import br.pucpr.action_hub_android.presentation.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(navController: NavController) {
    val viewModel: TaskViewModel = hiltViewModel()
    val tasks by viewModel.tasks.observeAsState(emptyList())
    val bold = FontFamily(
        Font(R.font.eduprebold, FontWeight.Normal)
    )
    val regular = FontFamily(
        Font(R.font.edupreregular, FontWeight.Normal)
    )

    LaunchedEffect(Unit) { viewModel.loadTasks() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xfff3f2f1))
            .padding(top = 32.dp)
    ) {
    Column {
        Button(onClick = { navController.navigate("add_task") }, modifier = Modifier.padding(horizontal = 8.dp)) {
            Text("Add Task")
        }
        LazyColumn(modifier = Modifier.padding(top = 32.dp)) {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .background(
                            color = Color(0xfffaf9f9),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                        .clickable {
                            navController.navigate("task_details/${task.id}")
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        fontSize = 32.sp,
                        fontFamily = regular,
                        text = task.title,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chevronright),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
        }
}
