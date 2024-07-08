package com.example.visuda.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.visuda.R
import com.example.visuda.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BerandaPage(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = remember { context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE) }
    var username = remember { sharedPreferences.getString("username", "User") }
    var nik = remember { sharedPreferences.getString("nik", "User") }
    var rt = remember { sharedPreferences.getString("rt", "User") }
    var rw = remember { sharedPreferences.getString("rw", "User") }
    var data by remember { mutableStateOf("26") } // Initial value of data

    val requestQueue: RequestQueue = Volley.newRequestQueue(context)

    LaunchedEffect(Unit) {
        while (true) {
            val url = "http://10.0.2.2:8080/riwayatOne"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    data = response // Directly set the response to data
                },
                { error ->
                    Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            )
            requestQueue.add(stringRequest)

            delay(1000) // Delay for 1 second
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bgberanda),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 170.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                        ) {
                            Text(
                                text = "Nama : $username",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = "NIK : $nik",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = "RW : $rw",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Start
                                ), modifier = Modifier.padding(4.dp)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "RT : $rt",
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        textAlign = TextAlign.Start
                                    ), modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.bendera),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Divider(
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_card),
                                    contentDescription = "Card",
                                    tint = Color.Black
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(text = "11***********9870", color = Color.Black)
                            }
                        }
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-40).dp, x = 120.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.White, CircleShape)
                        )
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Routes.Beranda.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                        .height(190.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083))
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = data,
                            color = Color.White,
                            style = TextStyle(fontSize = 50.sp) // Ubah ukuran font sesuai kebutuhan
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun preview() {
    BerandaPage(navController = rememberNavController())
}
