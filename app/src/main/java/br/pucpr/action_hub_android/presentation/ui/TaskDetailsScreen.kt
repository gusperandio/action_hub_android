package br.pucpr.action_hub_android.presentation.ui

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.pucpr.action_hub_android.presentation.viewmodel.TaskViewModel
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.pucpr.action_hub_android.R

@Composable
fun TaskDetailsScreen(navController: NavController, taskId: Int?) {
    val viewModel: TaskViewModel = hiltViewModel()
    val task = taskId?.let { viewModel.getTaskDetails(it) }
    val bold = FontFamily(
        Font(R.font.eduprebold, FontWeight.Normal)
    )
    val regular = FontFamily(
        Font(R.font.edupreregular, FontWeight.Normal)
    )

    Column {
        Row(
            modifier = Modifier
                .size(width = 42.dp, height = 42.dp)
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .background(
                    color = Color(0xfffaf9f9),
                    shape = RoundedCornerShape(4.dp)
                )
                .clip(RoundedCornerShape(4.dp))
                .clickable {
                    navController.navigate("task_list")
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.chevronleft),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                contentScale = ContentScale.Fit
            )
        }

        Row {
            task?.let {
                Column(modifier = Modifier.padding(8.dp)) {
                    Row {
                        Text("Title: ${it.title}", fontFamily = bold)
                    }
                    Row {
                        Text("Description: ${it.description}", fontFamily = regular)
                    }
                }
            } ?: Text("Task not found")
        }
    }
}