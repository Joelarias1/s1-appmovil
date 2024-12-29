package com.example.s1joelarias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.s1joelarias.screens.LoginScreen
import com.example.s1joelarias.ui.theme.S1joelariasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S1joelariasTheme {
                Surface {
                    // Llama a la pantalla de Login directamente
                    LoginScreen(onLoginSuccess = {
                        // todo: logica proxima evaluacion ?

                    })
                }
            }
        }
    }
}
