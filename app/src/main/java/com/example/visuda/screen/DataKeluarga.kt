package com.example.visuda.screen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.visuda.R
import com.example.visuda.navigation.Routes
import com.example.visuda.ui.theme.biru
import org.json.JSONArray
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataKeluargaPage(navController: NavHostController) {
    val context = LocalContext.current
    var familyMembers by remember { mutableStateOf<List<JSONObject>>(emptyList()) }
    var selectedMember by remember { mutableStateOf<JSONObject?>(null) }

    LaunchedEffect(Unit) {
        fetchFamilyMembers(context) { members ->
            familyMembers = members
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(biru)
    ) {
        Column(
            modifier = Modifier
                .background(biru)
                .padding(top = 30.dp, bottom = 30.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color(0xFF0A2083))
                    .padding(vertical = 16.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Data Keluarga",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                )
            }
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
                    Card(
                        onClick = { navController.navigate(Routes.TambahData.route) },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = biru,
                        ), modifier = Modifier.padding(start = 18.dp)
                    ) {
                        Text(
                            text = "Tambah Data",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            ), modifier = Modifier.padding(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))

                    familyMembers.forEachIndexed { index, member ->
                        FamilyMemberCard(member = member, index = index, navController = navController) {
                            selectedMember = member
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
        selectedMember?.let { member ->
            FamilyMemberDetailDialog(member = member, onClose = {
                selectedMember = null
                navController.popBackStack() // Kembali ke beranda navigasi setelah tutup dialog
            }, navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamilyMemberCard(member: JSONObject, index: Int, navController: NavHostController, onDetailClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE7EBFD)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 18.dp)
            .shadow(8.dp, shape = RoundedCornerShape(16.dp))
            .clickable { onDetailClick() }
    ) {
        Column {
            Row {
                Text(
                    text = "Data Keluarga ${member.optString("username")}",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier.padding(start = 10.dp, bottom = 4.dp, top = 30.dp, end = 116.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(56.dp)
                )
            }
            Text(
                text = "Nama : ${member.optString("username")}",
                style = TextStyle(
                    color = Color(0xFF0A2083),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                ), modifier = Modifier.padding(start = 10.dp, 4.dp)
            )
            Text(
                text = "Tanggal Lahir : ${member.optString("tanggal")}",
                style = TextStyle(
                    color = Color(0xFF0A2083),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                ), modifier = Modifier.padding(start = 10.dp, 4.dp)
            )
            Text(
                text = "Tempat Lahir : ${member.optString("tempat")}",
                style = TextStyle(
                    color = Color(0xFF0A2083),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                ), modifier = Modifier.padding(start = 10.dp, bottom = 8.dp,)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamilyMemberDetailDialog(member: JSONObject, onClose: () -> Unit, navController: NavHostController) {
    Dialog(
        onDismissRequest = onClose,
        content = {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE7EBFD)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Detail Anggota Keluarga",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Nama : ${member.optString("username")}",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Tanggal Lahir : ${member.optString("tanggal")}",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Tempat Lahir : ${member.optString("tempat")}",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "Update Anggota Keluarga",
                        style = TextStyle(
                            color = Color(0xFF0A2083),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    val nama = remember { mutableStateOf(TextFieldValue()) }
                    val tempat = remember { mutableStateOf(TextFieldValue()) }
                    val tanggal = remember { mutableStateOf(TextFieldValue()) }
                    val contextALEX = LocalContext.current
                    val requestQueueALEX = Volley.newRequestQueue(contextALEX)
                    fun textFieldModifier() = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
                        .border(
                            BorderStroke(1
                                .dp, Color.Gray.copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(8.dp)
                        )

                    Text(
                        text = "Nama Lengkap",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )

                    TextField(
                        label = { Text(text = "Nama Lengkap") },
                        value = nama.value,
                        onValueChange = { nama.value = it },
                        modifier = textFieldModifier(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Tempat Lahir",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )

                    TextField(
                        label = { Text(text = "Tempat Lahir") },
                        value = tempat.value,
                        onValueChange = { tempat.value = it },
                        modifier = textFieldModifier(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Tanggal Lahir",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )

                    TextField(
                        label = { Text(text = "Tanggal Lahir") },
                        value = tanggal.value,
                        onValueChange = { tanggal.value = it },
                        modifier = textFieldModifier(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val baseUrl = "http://10.0.2.2:8080/editData"
                            val params = "?username=${nama.value.text}&tempat=${tempat.value.text}&tanggal=${tanggal.value.text}&nik=${member.optString("nik")}"
                            val fullUrl = baseUrl + params

                            val stringRequest = object : StringRequest(
                                Request.Method.GET, fullUrl,
                                Response.Listener { response ->
                                    Log.d("RegisterResponse", "Response: $response")
                                    if (response == "\"SUCCESS\"") {
                                        Log.d("RegisterStatus", "Update successful")
                                        onClose() // Tutup dialog setelah update berhasil
//                                        navController.popBackStack() // Kembali ke beranda navigasi
                                        navController.navigate(Routes.Beranda.route)
                                    } else {
                                        Log.d("RegisterStatus", "Update failed")
                                    }
                                },
                                Response.ErrorListener { error ->
                                    Log.e("RegisterError", "Error: ${error.message}")
                                }
                            ) {
                                override fun getBodyContentType(): String {
                                    return "application/json; charset=utf-8"
                                }
                            }

                            requestQueueALEX.add(stringRequest)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0A2083),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Submit",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    )
}

fun fetchFamilyMembers(context: android.content.Context, onResult: (List<JSONObject>) -> Unit) {
    val url = "http://10.0.2.2:8080/data" // Replace with your endpoint URL
    val requestQueue = Volley.newRequestQueue(context)

    val stringRequest = StringRequest(
        Request.Method.GET, url,
        { response ->
            val members = mutableListOf<JSONObject>()
            try {
                val jsonArray = JSONArray(response)
                for (i in 0 until jsonArray.length()) {
                    val member = jsonArray.getJSONObject(i)
                    members.add(member)
                }
                onResult(members)
            } catch (e: Exception) {
                Log.e("FetchMembers", "Error parsing JSON", e)
            }
        },
        { error ->
            Log.e("FetchMembers", "Error fetching data: ${error.message}")
        })

    requestQueue.add(stringRequest)
}

@Preview(showBackground = true)
@Composable
fun DataKeluargaPagePreview() {
    val navController = rememberNavController()
    DataKeluargaPage(navController = navController)
}
