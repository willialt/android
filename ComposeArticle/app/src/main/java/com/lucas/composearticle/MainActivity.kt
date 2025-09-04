package com.lucas.composearticle

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TitleImage(
                        title = "Jetpack Compose Tutorial",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun TitleImage(title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        verticalArrangement = Arrangement.Center,
//        modifier = modifier.padding(8.dp)
    ) {
        Box(modifier) {
            Image(
                painter = image,
                contentDescription = null,
//                contentScale = ContentScale.Crop
            )
        }
        TitleText(title = title, modifier = Modifier) // add title composable
        BodyText("Jetpack Compose is a modern toolkit for building native Android UI. " +
                "Compose simplifies and accelerates UI development on Android with less code, " +
                "powerful tools, and intuitive Kotlin APIs.")
        BodyText(body = "In this tutorial, you build a simple UI component with declarative " +
                "functions. You call Compose functions to say what elements you want and the " +
                "Compose compiler does the rest. Compose is built around Composable functions. " +
                "These functions let you define your app\\'s UI programmatically because they " +
                "let you describe how it should look and provide data dependencies, rather than " +
                "focus on the process of the UI\\'s construction, such as initializing an element" +
                " and then attaching it to a parent. To create a Composable function, you add" +
                " the @Composable annotation to the function name.")


    }

}

@Composable
fun TitleText(title: String, modifier: Modifier = Modifier) {

    Box {
        Text(
            text = title,
            fontSize = 24.sp, // needs to be sp not dp
//            lineHeight = 40.sp, // needs to be sp not dp
//            textAlign = TextAlign.Left,
            modifier = modifier
                .padding(16.dp)
        )
    }
}
@Composable
fun BodyText(body: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Text(
            text = body,
//            fontSize = 16.sp,
//            lineHeight = 22.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        TitleImage("Jetpack Compose Tutorial")
    }
}