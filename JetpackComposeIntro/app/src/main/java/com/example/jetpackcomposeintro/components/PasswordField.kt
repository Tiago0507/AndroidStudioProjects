package com.example.jetpackcomposeintro.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordField(modifier: Modifier = Modifier, onValue:(String)->Unit, value:String) {

    var showPassword by remember {
        mutableStateOf(false)
    }

    Row(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValue,
            modifier = Modifier.weight(1f),
            visualTransformation = if(showPassword) VisualTransformation.None else PasswordVisualTransformation()
        )
        Box(modifier = Modifier.width(8.dp))
        Button(onClick = {
            showPassword = showPassword.not()
        }, modifier = Modifier.width(56.dp).height(56.dp)) {
            Text(text = "H")
        }
    }
}