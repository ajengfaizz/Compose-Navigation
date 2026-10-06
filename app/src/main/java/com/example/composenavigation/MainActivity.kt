package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val nim = "245150407111035"
    val name = "Ajeng Nurul Faizah"

    NavHost(
        navController = navController,
        startDestination = "screen1",
        modifier = modifier
    ) {
        composable("screen1") {
            Screen1(
                nim = nim,
                name = name,
                navController = navController
            )
        }
        composable("Screen2") {
            Screen2(
                nim = nim,
                name = name
            )
        }
    }
}

@Composable
fun Screen1(
    nim: String,
    name: String,
    navController: NavController
)  {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "NIM: $nim", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Nama: $name", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Screen1", fontSize = 24.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("Screen2") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ke Halaman 2")
        }
    }
}

@Composable
fun Screen2(
    nim: String,
    name: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "NIM: $nim", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Nama: $name", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Screen2", fontSize = 24.sp, fontWeight = FontWeight.Medium)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
    //ComposeNavigationTheme { Greeting("Android") }NavigationTheme {
       // Greeting("Android")
    //}
//}