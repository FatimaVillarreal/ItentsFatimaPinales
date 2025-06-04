package com.example.fatimapinales

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var input by remember { mutableStateOf("") }

            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.nombre_alumno),
                        fontSize = 22.sp,
                        style = MaterialTheme.typography.titleMedium
                    )

                    OutlinedTextField(
                        value = input,
                        onValueChange = { input = it },
                        label = { Text("Escribe un texto") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Button(
                                onClick = {
                                    val intent = Intent(context, SecondActivity::class.java)
                                    intent.putExtra("texto", input)
                                    context.startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Ir a segunda Activity")
                            }

                            Button(
                                onClick = {
                                    val intent = Intent(context, ThirdActivity::class.java)
                                    intent.putExtra("saludo", "Hola desde MainActivity")
                                    context.startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Ir a tercera Activity (saludo)")
                            }

                            Divider()

                            Button(
                                onClick = {
                                    val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                                    context.startActivity(urlIntent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Abrir Navegador")
                            }

                            Button(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW)
                                    intent.data = Uri.parse("https://wa.me/5211234567890") // Ajusta el número
                                    context.startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Abrir WhatsApp")
                            }

                            Button(
                                onClick = {
                                    val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=escuela"))
                                    context.startActivity(mapIntent)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Abrir Mapas")
                            }
                        }
                    }
                }
            }
        }
    }
}

