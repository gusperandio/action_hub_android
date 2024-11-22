package br.pucpr.action_hub_android.presentation.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.pucpr.action_hub_android.R

@Composable
fun CardTask(title: String, desc: String) {
    val bold = FontFamily(
        Font(R.font.recursivebold, FontWeight.Normal)
    )
    val regular = FontFamily(
        Font(R.font.recursivelight, FontWeight.Normal)
    )

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp) ,
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xff222222) // Custom background color
        )
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(18.dp),
            textAlign = TextAlign.Center,
            fontFamily = bold,
            color = Color.White
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
            .padding(horizontal = 2.dp))

        Text(
            text = desc,
            modifier = Modifier
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontFamily = regular,
            color = Color.White
        )
    }
}