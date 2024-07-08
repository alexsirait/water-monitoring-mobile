package com.example.visuda.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.visuda.R
import com.example.visuda.navigation.Routes
import com.example.visuda.ui.theme.biru

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = remember { context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE) }
    val coroutineScope = rememberCoroutineScope()
    var username = remember { sharedPreferences.getString("username", "User") }
    var nik = remember { sharedPreferences.getString("nik", "User") }
    var rt = remember { sharedPreferences.getString("rt", "User") }
    var rw = remember { sharedPreferences.getString("rw", "User") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(biru)
    ) {
        Column(
            modifier = Modifier
                .background(biru)
                .padding(top = 30.dp),
        ) {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Profile Saya", style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF0A2083),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
        Box(
            modifier = Modifier
                .background(biru),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "$username",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 30.dp, end = 78.dp, bottom = 1.dp)
                            )
                            Text(
                                text = "$nik",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 10.dp, end = 78.dp, bottom = 8.dp)
                            )
//                            Card(
//                                onClick = { navController.navigate(Routes.EditProfile.route)},
//                                shape = RoundedCornerShape(12.dp),
//                                elevation = CardDefaults.cardElevation(16.dp),
//                                colors = CardDefaults.cardColors(
//                                    containerColor = biru
//                                )
//                            ) {
//                                Text(
//                                    text = "Edit Profile",
//                                    style = TextStyle(
//                                        color = Color.White,
//                                        fontSize = 14.sp,
//                                        textAlign = TextAlign.Center
//                                    ), modifier = Modifier.padding(10.dp)
//                                )
//                            }
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row(
                        modifier = Modifier
                            .clickable { navController.navigate(Routes.TentangKami.route) }
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.iinfo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(70.dp)
                                .padding(start = 18.dp, end = 18.dp)
                        )
                        Column {
                            Text(
                                text = "Tentang Kami",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 24.dp)
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = { navController.navigate(Routes.Login.route) },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .height(62.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083))
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Spacer(Modifier.width(8.dp))
                                Text(text = "LOGOUT", color = Color.White)
                            }
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    val navController = rememberNavController()
    ProfilePage(navController = navController)
}