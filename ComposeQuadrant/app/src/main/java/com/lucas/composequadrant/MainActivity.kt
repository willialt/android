package com.lucas.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.composequadrant.ui.theme.ComposeQuadrantTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
//                    contentWindowInserts = WindowInsets(0)
                ) { innerPadding ->
                    Quadrant(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
//        verticalArrangement = Arrangement.Top
    ){
        Row(
            modifier = modifier
                .weight(1f), // top half
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
        ){
            // text 1
            TextBox(
                title = "Text composable",
                text = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier
                    .weight(1f) // left half
                    .fillMaxSize()
                    .background(Color(0xFFEADDFF))

            )
            // text 2
            TextBox(
                title = "Image composable",
                text = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f) // right half
                    .fillMaxSize()
                    .background(Color(0xFFD0BCFF))
            )

        }
        Row(
            modifier = modifier.weight(1f), // bottom half
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            // text 3
            TextBox(
                title = "Row composable",
                text = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .weight(1f) // left half
                    .fillMaxSize()
                    .background(Color(0xFFB69DF8))
            )
            // text 4
            TextBox(
                title = "Column composable",
                text = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFF6EDFF))
            )

        }
    }
}
@Composable
fun TextBox(title: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quadrant()
    }
}
