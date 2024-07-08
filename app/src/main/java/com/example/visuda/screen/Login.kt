package com.example.visuda.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.visuda.R
import com.example.visuda.navigation.Routes
import org.json.JSONException
import org.json.JSONObject
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    val context = LocalContext.current
    val requestQueue = remember { Volley.newRequestQueue(context) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bglogin),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 400.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Selamat Datang Kembali",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    val username = remember { mutableStateOf(TextFieldValue()) }
                    val password = remember { mutableStateOf(TextFieldValue()) }

                    Text(
                        text = "Nama Pengguna",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        placeholder = { Text(text = "Masukkan Username", style = TextStyle(color = Color.Gray)) },
                        value = username.value,
                        onValueChange = { username.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        textStyle = TextStyle(textAlign = TextAlign.Start)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Kata Sandi",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    TextField(
                        placeholder = { Text(text = "Masukkan Kata Sandi", style = TextStyle(color = Color.Gray)) },
                        value = password.value,
                        onValueChange = { password.value = it },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        textStyle = TextStyle(textAlign = TextAlign.Start)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            val baseUrl = "http://10.0.2.2:8080/auth"
                            val username = username.value.text
                            val password = password.value.text
                            val url = "$baseUrl?username=${URLEncoder.encode(username, "UTF-8")}&password=${URLEncoder.encode(password, "UTF-8")}"

                            val stringRequest = StringRequest(
                                Request.Method.GET, url,
                                { response ->
                                    Log.d("LoginResponse", "Response: $response")
                                    if (response == "\"SUCCESS\"") {
                                        // Save username to SharedPreferences and fetch additional details
                                        val detailUrl = "http://10.0.2.2:8080/detail?username=${URLEncoder.encode(username, "UTF-8")}"
                                        val detailRequest = StringRequest(
                                            Request.Method.GET, detailUrl,
                                            { detailResponse ->
                                                try {
                                                    val jsonObject = JSONObject(detailResponse)
                                                    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
                                                    val editor = sharedPreferences.edit()
                                                    editor.putString("username", jsonObject.getString("username"))
                                                    editor.putString("nik", jsonObject.getString("nik"))
                                                    editor.putString("rt", jsonObject.getString("rt"))
                                                    editor.putString("rw", jsonObject.getString("rw"))
                                                    editor.apply()

                                                    Log.d("LoginStatus", "Login successful")
                                                    navController.navigate(Routes.Beranda.route)
                                                } catch (e: JSONException) {
                                                    Log.e("DetailError", "JSON Parsing Error: ${e.message}")
                                                    Toast.makeText(context, "Failed to parse user details.", Toast.LENGTH_SHORT).show()
                                                }
                                            },
                                            { error ->
                                                Log.e("DetailError", "Error: ${error.message}")
                                                Toast.makeText(context, "Failed to fetch user details.", Toast.LENGTH_SHORT).show()
                                            }
                                        )
                                        requestQueue.add(detailRequest)
                                    } else {
                                        Log.d("LoginStatus", "Login failed")
                                        Toast.makeText(context, "Login failed. Try again.", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                { error ->
                                    Log.e("LoginError", "Error: ${error.message}")
                                    Toast.makeText(context, "Error during login.", Toast.LENGTH_SHORT).show()
                                }
                            )
                            requestQueue.add(stringRequest)
                        },
                                shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A2083)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Text(text = "Masuk", color = Color.White)
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    ClickableText(
                        text = buildAnnotatedString {
                            append("Belum punya akun? ")
                            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                                append("Daftar")
                            }
                            append(" disini")
                        },
                        onClick = {
                            navController.navigate(Routes.Daftar.route)
                        },
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val navController = rememberNavController()
    LoginPage(navController = navController)
}
