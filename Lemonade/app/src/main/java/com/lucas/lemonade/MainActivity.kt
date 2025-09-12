package com.lucas.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun LemonApp(
    modifier: Modifier = Modifier
) {

    var state by remember { mutableStateOf(1) }
    var squeezes by remember { mutableStateOf(0) }
    var targetSqueezes by remember { mutableStateOf(Random.nextInt(2, 5)) }

    when (state) {
        1 -> LemonPage(
            description = stringResource(R.string.tap_tree),
            lemonPic = painterResource(R.drawable.lemon_tree),
            // pass lambda func as parameter
            onImageClick = {
                squeezes = 0
                targetSqueezes = Random.nextInt(2, 5)
                state = 2
            }
        )

        2 -> LemonPage(
            description = stringResource(R.string.squeeze),
            lemonPic = painterResource(R.drawable.lemon_squeeze),
            onImageClick = {
                squeezes++
                if (squeezes > targetSqueezes) {
                    state = 3
                }
            }
        )

        3 -> LemonPage(
            description = stringResource(R.string.drink),
            lemonPic = painterResource(R.drawable.lemon_drink),
            onImageClick = {
                state = 4
            }
        )

        4 -> LemonPage(
            description = stringResource(R.string.restart),
            lemonPic = painterResource(R.drawable.lemon_restart),
            onImageClick = {
                state = 1
            }
        )

        else -> LemonPage(
            description = stringResource(R.string.restart),
            lemonPic = painterResource(R.drawable.lemon_restart),
            onImageClick = {
                state = 1
            }
        )
    }
}

@Composable
fun LemonPage(
    description: String,
    lemonPic: Painter,
    onImageClick: () -> Unit, // lambda function controlling state
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Yellow)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Lemonade",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
//            Button(
//                onClick = { onImageClick() }, // Fixed: need to call the function with ()
//                shape = RoundedCornerShape(16.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = androidx.compose.ui.graphics.Color.LightGray
//                ),
//                modifier = Modifier
//                    .size(200.dp)
//                    .padding(8.dp)
//            ) {
//                Image(
//                    painter = lemonPic,
//                    contentDescription = description,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(8.dp)
//                )
//            } // Fixed: Added missing closing brace
            Image(
                painter = lemonPic,
                contentDescription = description,
                modifier = Modifier
                    .clickable { onImageClick() }
            )

            Text(
                text = description,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
//package com.lucas.lemonade
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color.Companion.Yellow
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.lucas.lemonade.ui.theme.LemonadeTheme
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import kotlin.random.Random
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            LemonadeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    LemonApp(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun LemonApp(
//    modifier: Modifier = Modifier
//) {
//    var state by remember { mutableStateOf(1) }
//    var squeezes by remember { mutableStateOf(0) }
//    var targetSqueezes by remember { mutableStateOf(Random.nextInt(2, 5)) }
//
//    when (state) {
//        1 -> LemonPage(
//            description = stringResource(R.string.tap_tree),
//            lemonPic = painterResource(R.drawable.lemon_tree),
//            // pass lambda func as parameter
//            onImageClick = {
//                squeezes = 0
//                targetSqueezes = Random.nextInt(2, 5)
//                state = 2
//            }
//        )
//
//        2 -> LemonPage(
//            description = stringResource(R.string.squeeze),
//            lemonPic = painterResource(R.drawable.lemon_squeeze),
//            onImageClick = {
//                squeezes++
//                if (squeezes >= targetSqueezes) { // Fixed: should be >= not >
//                    state = 3
//                }
//            }
//        )
//
//        3 -> LemonPage(
//            description = stringResource(R.string.drink),
//            lemonPic = painterResource(R.drawable.lemon_drink),
//            onImageClick = {
//                state = 4
//            }
//        )
//
//        4 -> LemonPage(
//            description = stringResource(R.string.restart),
//            lemonPic = painterResource(R.drawable.lemon_restart),
//            onImageClick = {
//                state = 1
//            }
//        )
//
//        else -> LemonPage(
//            description = stringResource(R.string.restart),
//            lemonPic = painterResource(R.drawable.lemon_restart),
//            onImageClick = {
//                state = 1
//            }
//        )
//    }
//}
//
//@Composable
//fun LemonPage(
//    description: String,
//    lemonPic: Painter,
//    onImageClick: () -> Unit, // lambda function controlling state
//    modifier: Modifier = Modifier
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier
//    ) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .background(Yellow)
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Text(
//                text = "Lemonade",
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }
//
//        Column(
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Button(
//                onClick = { onImageClick() }, // Fixed: need to call the function with ()
//                shape = RoundedCornerShape(16.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = androidx.compose.ui.graphics.Color.LightGray
//                ),
//                modifier = Modifier
//                    .size(200.dp)
//                    .padding(8.dp)
//            ) {
//                Image(
//                    painter = lemonPic,
//                    contentDescription = description,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(8.dp)
//                )
//            } // Fixed: Added missing closing brace
//
//            Text(
//                text = description,
//                modifier = Modifier
//                    .padding(16.dp)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun LemonPreview() {
//    LemonadeTheme {
//        LemonApp()
//    }
//}
