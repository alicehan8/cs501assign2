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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
        }
    }
}