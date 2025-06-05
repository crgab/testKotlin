package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.models.Pessoa
import com.example.test.models.Produto
import com.example.test.ui.theme.TestTheme
import com.example.test.views.FichaPessoal
import com.example.test.views.ListaDeProdutos
import com.example.test.views.PessoaCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
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
    val produtos = listOf(
        Produto("Arroz", 8.0, false),
        Produto("Feijão", 10.5, false),
        Produto("Café", 15.1, true),
        Produto("Leite", 9.99, true),
        Produto("Azeite Português", 89.99, true),
        Produto("Queijo", 12.87, true),
        Produto("Batata Escovada", 5.99, true)
    )
    ListaDeProdutos(produtos)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("Android")
    }
}