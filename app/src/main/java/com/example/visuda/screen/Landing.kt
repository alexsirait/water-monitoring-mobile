package com.example.visuda.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.visuda.R
import com.example.visuda.navigation.Routes

@Composable
fun LandingPage(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Content Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Visuda Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(bottom = 16.dp)
            )


            Text(
                text = "Water Monitoring",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )


            Text(
                text = "Selamat Datang di Aplikasi Water Monitoring",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )


            Spacer(modifier = Modifier.height(32.dp))


            Button(
                onClick = { navController.navigate(Routes.Login.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(text = "MASUK",
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }


            Spacer(modifier = Modifier.height(16.dp))


            OutlinedButton(
                onClick = { navController.navigate(Routes.Daftar.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp)),
                border = BorderStroke(2.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
            ) {
                Text(text = "DAFTAR",
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
        }
    }
}
