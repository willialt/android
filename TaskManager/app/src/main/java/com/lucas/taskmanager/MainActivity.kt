package com.lucas.taskmanager

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
import com.lucas.taskmanager.ui.theme.TaskManagerTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeTaskManagerApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Calls to resources here
@Composable
fun ComposeTaskManagerApp(modifier: Modifier = Modifier) {
    ManagerCard(
        image = painterResource(R.drawable.ic_task_completed),
        text1 = stringResource(R.string.line_one_text),
        text2 = stringResource(R.string.line_two_text),
        modifier = modifier
    )
}
@Composable
private fun ManagerCard(
    image: Painter,
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ){
        // Image
        Image(
            painter = image,
            contentDescription = null
        )
        // Text 1
        Text(
            text = text1,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        // Text 2
        Text(
            text = text2,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        ComposeTaskManagerApp(
            modifier = Modifier
                .padding(2.dp) // changes padding around column from top level
                .background(Color.White) // changes column color from top level
        )
    }
}