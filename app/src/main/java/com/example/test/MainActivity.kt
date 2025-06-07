package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test.models.Client
import com.example.test.models.Employee
import com.example.test.models.Product
import com.example.test.models.SaleGet
import com.example.test.services.ApiService
import com.example.test.ui.theme.TestTheme
import com.example.test.views.SwipePagerScreen

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
    var clients by remember { mutableStateOf<List<Client>>(emptyList()) }
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var employees by remember { mutableStateOf<List<Employee>>(emptyList()) }
    var sales by remember { mutableStateOf<List<SaleGet>>(emptyList()) }

    LaunchedEffect(Unit) {
        clients = ApiService.getClients()
        products = ApiService.getProducts()
        employees = ApiService.getEmployees()
        sales = ApiService.getSales()
    }
    SwipePagerScreen(clients, products, employees, sales)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("Android")
    }
}