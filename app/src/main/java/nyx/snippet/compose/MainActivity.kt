package nyx.snippet.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nyx.snippet.compose.ui.theme.Pa1snippetcomposeTheme
import nyx.snippet.compose.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pa1snippetcomposeTheme {
                MyUnitExample(someText = null) {
                    MyGreeting()
                }
            }
        }
    }
}

@Composable
fun MyHelloWorld(someText: String?) = Text(text = someText ?: "someText is null.")

@Composable
fun MyGreeting() {
    val names = listOf("Amir", "Bob", "Carol", "Demeter", "Erebos", "Felix")
    var greeting by remember { mutableStateOf("") }

    Column(Modifier.background(Teal200)) {
        Text(greeting)
        Button(onClick = {
            greeting = "Hello ${names.random()}!"
        }) {
            Text("say hello")
        }
    }
}

@Composable
fun MyUnitExample(someText: String?, content: @Composable () -> Unit) =
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyHelloWorld(someText)
        content()
    }