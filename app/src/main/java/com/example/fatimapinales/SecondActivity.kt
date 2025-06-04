package com.example.fatimapinales


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val texto = intent.getStringExtra("texto") ?: "Sin texto"

        setContent {
            Surface(modifier = Modifier.padding(16.dp)) {
                Text("Texto recibido: $texto")
            }
        }
    }
}
