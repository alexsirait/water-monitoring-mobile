package com.example.visuda.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

data class Submission(val title: String, val date: String, val status: String, val statusColor: Color)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiwayatPage(navController: NavHostController) {
    val context = LocalContext.current
    val submissions = remember { mutableStateListOf<Submission>() }

    // Fetch submissions
    val requestQueue = Volley.newRequestQueue(context)
    val url = "http://10.0.2.2:8080/riwayat"

    val stringRequest = StringRequest(
        Request.Method.GET, url,
        { response ->
            try {
                val jsonArray = JSONArray(response)
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val title = jsonObject.getString("type")
                    val date = jsonObject.getString("date")
                    val status = jsonObject.getString("nama")
                    val statusColor = when (status) {
                        "Dibatalkan" -> Color.Red
                        "Selesai" -> Color.Green
                        "Proses" -> Color.Yellow
                        else -> Color.Gray
                    }
                    submissions.add(Submission(title, date, status, statusColor))
                }
            } catch (e: JSONException) {
                Log.e("RiwayatPage", "JSON Parsing error: ${e.message}")
                Toast.makeText(context, "Failed to parse submissions.", Toast.LENGTH_SHORT).show()
            }
        },
        { error ->
            Log.e("RiwayatPage", "Request error: ${error.message}")
            Toast.makeText(context, "Failed to fetch submissions.", Toast.LENGTH_SHORT).show()
        }
    )
    requestQueue.add(stringRequest)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0A2083))
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
                IconButton(onClick = { /* Handle search icon press */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0A2083))
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Section(title = "Hari Ini")
                    submissions.forEach { submission ->
                        SubmissionCard(
                            title = submission.title,
                            date = submission.date,
                            status = submission.status,
                            statusColor = submission.statusColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Section(title: String) {
    Text(
        text = title,
        style = TextStyle(
            color = Color(0xFF0A2083),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun SubmissionCard(title: String, date: String, status: String, statusColor: Color) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Text(
                    text = date,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(statusColor, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = status,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RiwayatPagePreview() {
    val navController = rememberNavController()
    RiwayatPage(navController = navController)
}
