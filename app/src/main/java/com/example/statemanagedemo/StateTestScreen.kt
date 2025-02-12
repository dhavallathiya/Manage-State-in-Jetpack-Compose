package com.example.statemanagedemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


// remember -> persist state on recomposition
//rememberSaveabIe -> persist even on configuration changes
// ViewModeI and Livedata -> Hoist the state for re-usability

@Composable
fun StateTextScreen(viewModel: StateTestViewModel) {
    val name by viewModel.name.observeAsState("")
    val surname by viewModel.surname.observeAsState("")

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText("$name $surname")
        MyTextField(name, onNameChange = { viewModel.onNameChange(it) })
        MyTextField(surname, onNameChange = { viewModel.onSurNameChange(it) })
    }
}

@Composable
fun MyText(name: String) {
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name: String, onNameChange: (String) -> Unit) {


    OutlinedTextField(
        value = name,
        onValueChange = { onNameChange(it) },
        label = { Text("Enter your name") }
    )
}