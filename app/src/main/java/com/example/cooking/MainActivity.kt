package com.example.cooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.ui.theme.CookingTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookingTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        GenerateOutLinedTextField(
                            placeholder = "Example@gmail.com",
                            label = "Email"
                        )
//                        Greeting("Android")
//                        MakeText("It's me")
                    }

                }

            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun GenerateOutLinedTextField(defaultText: String = "", placeholder: String, label: String) {
    var text by rememberSaveable { mutableStateOf(defaultText) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .padding(horizontal = 20.dp),
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = 25.sp
    )
}

@Composable
fun MakeText(name: String) {
    Text(text = name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CookingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                GenerateOutLinedTextField(placeholder = "Example@gmail.com", label = "Email")
                GenerateOutLinedTextField(placeholder = "Password", label = "Password")
            }
        }


    }
}