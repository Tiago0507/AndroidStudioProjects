package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var account by remember {
                        mutableStateOf(0)
                    }

                    ScreenB(counter = account, {
                        account = it+10
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatBubblePreview() {
    Lab1Theme {
        ChatBubble()
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    Lab1Theme {
        //SignUpScreen()
    }
}

@Preview
@Composable
fun ScreenBPreview() {
    Lab1Theme {
        //ScreenB()
    }
}

@Composable
fun ScreenB(
    counter:Int,
    counterFunction: (Int) -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    Column {
        Text(text = "La cuenta va en ${counter}", color = Color.White)
        Button(onClick = {counterFunction(counter)}) {
            Text(text = "Contar")
        }
        TextField(value = email, onValueChange = {
            email = it
        })
    }
}