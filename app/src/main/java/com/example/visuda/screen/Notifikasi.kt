package com.example.visuda.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.visuda.ui.theme.biru

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiPage(navController: NavHostController) {
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
                        Text(text = "Riwayat Pengajuan", style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF0A2083),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
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
                            painter = painterResource(id = R.drawable.imerah),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Pengajuan Ditolak",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Berkas yang dilampirkan tidak lengkap",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ihijau),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Pengajuan Dikirim",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Pengajuan sukses dikirim",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ikuning),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Menunggu Konfirmasi",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Pengajuan sedang diproses",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.imerah),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Pengajuan Ditolak",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Berkas yang dilampirkan tidak lengkap",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ihijau),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Pengajuan Dikirim",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Pengajuan sukses dikirim",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ikuning),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .padding(start = 24.dp, end = 20.dp)
                        )
                        Column {
                            Text(
                                text = "Menunggu Konfirmasi",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                ),
                                modifier = Modifier.padding(top = 18.dp, end = 78.dp, bottom = 8.dp)
                            )
                            Text(
                                text = "Pengajuan sedang diproses",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 18.dp, end = 18.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotifikasiPagePreview() {
    val navController = rememberNavController()
    NotifikasiPage(navController = navController)
}