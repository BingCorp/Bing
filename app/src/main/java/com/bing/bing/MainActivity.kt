package com.bing.bing

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bing.bing.model.SignupRequest
import com.bing.bing.ui.theme.BingTheme
import com.bing.bing.vm.SignupViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val signupViewModel: SignupViewModel = viewModel()
    val state = remember { mutableStateOf("2") }
    val request = SignupRequest("309324904@qq.com","123456")
    Column {
        Button(onClick = {
            signupViewModel.viewModelScope.launch {
                signupViewModel.signup(request)
                signupViewModel.signupResult.collect {
                    Log.e("获取id", it.id.toString())
                    state.value = it.id.toString()
                }
            }

        }) {
            Text(text = "获取")
        }
        Text(text = state.value)
    }
}
