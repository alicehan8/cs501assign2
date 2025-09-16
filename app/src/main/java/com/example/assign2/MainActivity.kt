package com.example.assign2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assign2.ui.theme.Assign2Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Text("ColorCard")
                        ColorCard(Color.Red, "red", Modifier
                            .padding(5.dp)
                            .border(4.dp, Color.Black))
                        ColorCard(Color.Blue, "blue", Modifier.background(Color.Cyan).size(width=100.dp, height=100.dp))
                        ColorCard(Color.Green, "green", Modifier.background(Color.Yellow).padding(5.dp))

                        Text("ToggleCard")
                        ToggleCard("Hello", "Goodbye", Modifier.padding(5.dp))

                        Text("KotlinPracticeScreen")
                        KotlinPracticeScreen("cat")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ColorCard(color: Color, label: String, modifier: Modifier) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = modifier.size(width=240.dp, height=100.dp)
    ){
        Text(label, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ToggleCard(initMessage: String, changeMessage: String, modifier: Modifier) {
    var toggled by rememberSaveable { mutableStateOf(false) }
    Card (
        colors = CardDefaults.cardColors(
            containerColor = if (toggled) Color.Green else Color.Red
        ),
        onClick = { toggled = !toggled },
        modifier = modifier
    ){
        Text(if (toggled) changeMessage else initMessage, modifier = modifier.padding(16.dp))
    }
}

@Composable
fun KotlinPracticeScreen(input: String, modifier: Modifier = Modifier) {
    val sound = when (input) {
        "cat" -> "meow"
        "dog" -> "woof"
        "cow" -> "moo"
        "fish" -> "glug"
        else -> "I don't know that animal"
    }

    var count by remember { mutableStateOf(0) }
    var errorText by remember { mutableStateOf<String?>(null)}

    Text("$input goes $sound")
    Button(onClick = {
        if (count <5) {
            count = count + 1
        }else{
            errorText = "Count is already at 5"
        }}){
        Text("Increment Count")
    }
    Text("Count: $count")
    errorText?.let{
        Text(errorText?:"", color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assign2Theme {
        Column() {
            ColorCard(Color.Red, "red", Modifier
                .padding(5.dp)
                .border(4.dp, Color.Black))
            ColorCard(Color.Blue, "blue", Modifier.background(Color.Cyan).size(width=100.dp, height=100.dp))
            ColorCard(Color.Green, "green", Modifier.background(Color.Yellow).padding(5.dp))
            ToggleCard("Hello", "Goodbye", Modifier.padding(5.dp))
            KotlinPracticeScreen("cat")
        }
    }
}