package com.example.visuda.components

import android.app.DatePickerDialog
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.visuda.model.FormConfig
import com.example.visuda.model.FormField
import com.example.visuda.model.InputType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicForm(navController: NavHostController, formConfig: FormConfig) {
    val context = LocalContext.current
    val requestQueue = remember { Volley.newRequestQueue(context) }

    // State variables for each form field
    val nik = remember { mutableStateOf("") }
    val nama = remember { mutableStateOf("") }
    val jk = remember { mutableStateOf("") }
    val tempat = remember { mutableStateOf("") }
    val tanggal = remember { mutableStateOf("") }
    val alamat = remember { mutableStateOf("") }
    val rt = remember { mutableStateOf("") }
    val rw = remember { mutableStateOf("") }
    val agama = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A2083))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFF0A2083))
                .padding(horizontal = 16.dp, vertical = 16.dp)
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
                text = formConfig.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
        }

        Box(
            modifier = Modifier
                .background(Color(0xFF0A2083)),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
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
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {

                    fun textFieldModifier() = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                        .border(
                            BorderStroke(1.dp, Color.Gray.copy(alpha = 0.5f)),
                            shape = RoundedCornerShape(8.dp)
                        ).height(38.dp)

                    formConfig.fields.forEach { formField ->
                        Column(modifier = Modifier.padding(vertical = 8.dp)) {
                            Text(
                                text = formField.label,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Start
                                ),
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            when (formField.inputType) {
                                InputType.TEXT -> {
                                    var text by remember { mutableStateOf("") }
                                    TextField(
                                        value = text,
                                        onValueChange = {
                                            text = it
                                            when (formField.label) {
                                                "Nama Lengkap" -> nama.value = it
                                                "Tempat Lahir" -> tempat.value = it
                                                "Alamat" -> alamat.value = it
                                            }
                                        },
                                        label = { Text(text = formField.label, style = TextStyle(color = Color.Gray)) },
                                        placeholder = { Text(formField.placeholder) },
                                        shape = RoundedCornerShape(16.dp),
                                        modifier = textFieldModifier(),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedTextColor = Color.Black,
                                            unfocusedTextColor = Color.Black
                                        ),
                                        textStyle = TextStyle(textAlign = TextAlign.Start)
                                    )
                                }

                                InputType.NUMBER -> {
                                    var number by remember { mutableStateOf("") }
                                    TextField(
                                        value = number,
                                        onValueChange = {
                                            number = it
                                            when (formField.label) {
                                                "NIK" -> nik.value = it
                                                "Wilayah RT" -> rt.value = it
                                                "Wilayah RW" -> rw.value = it
                                            }
                                        },
                                        label = { Text(text = formField.label, style = TextStyle(color = Color.Gray)) },
                                        placeholder = { Text(formField.placeholder) },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                        shape = RoundedCornerShape(16.dp),
                                        modifier = textFieldModifier(),
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedTextColor = Color.Black,
                                            unfocusedTextColor = Color.Black
                                        ),
                                        textStyle = TextStyle(textAlign = TextAlign.Start)
                                    )
                                }

                                InputType.DROPDOWN -> {
                                    var expanded by remember { mutableStateOf(false) }
                                    var selectedOption by remember { mutableStateOf("") }
                                    val options = listOf("Option 1", "Option 2", "Option 3")

                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        TextField(
                                            value = selectedOption,
                                            onValueChange = { },
                                            label = { Text(text = formField.label, style = TextStyle(color = Color.Gray)) },
                                            placeholder = { Text(formField.placeholder) },
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = textFieldModifier().clickable { expanded = true },
                                            colors = TextFieldDefaults.textFieldColors(
                                                containerColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedTextColor = Color.Black,
                                                unfocusedTextColor = Color.Black
                                            ),
                                            textStyle = TextStyle(textAlign = TextAlign.Start),
                                            readOnly = true,
                                            trailingIcon = {
                                                Icon(
                                                    Icons.Default.ArrowDropDown,
                                                    contentDescription = null
                                                )
                                            }
                                        )
                                        DropdownMenu(
                                            expanded = expanded,
                                            onDismissRequest = { expanded = false }
                                        ) {
                                            options.forEach { option ->
                                                DropdownMenuItem(
                                                    text = {
                                                        Text(option)
                                                    },
                                                    onClick = {
                                                        selectedOption = option
                                                        expanded = false
                                                        when (formField.label) {
                                                            "Jenis Kelamin" -> jk.value = option
                                                            "Agama" -> agama.value = option
                                                        }
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                InputType.DATE -> {
                                    val context = LocalContext.current
                                    val selectedDate = remember { mutableStateOf("") }
                                    val datePickerDialog = remember {
                                        DatePickerDialog(context, { _, year, month, dayOfMonth ->
                                            selectedDate.value = "$dayOfMonth/${month + 1}/$year"
                                            tanggal.value = selectedDate.value
                                        }, 2022, 1, 1)
                                    }

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp)
                                    ) {
                                        TextField(
                                            label = { Text(text = formField.label, style = TextStyle(color = Color.Gray)) },
                                            value = selectedDate.value,
                                            onValueChange = { selectedDate.value = it },
                                            modifier = textFieldModifier().clickable { datePickerDialog.show() },
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
                                            },
                                            readOnly = true
                                        )
                                    }
                                }

                                InputType.IMAGE -> {
                                    var imageUri by remember { mutableStateOf<Uri?>(null) }
                                    val launcher = rememberLauncherForActivityResult(
                                        contract = ActivityResultContracts.GetContent(),
                                        onResult = { uri: Uri? -> imageUri = uri }
                                    )

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp)
                                    ) {
                                        imageUri?.let {
                                            Image(
                                                painter = rememberAsyncImagePainter(model = it),
                                                contentDescription = null,
                                                modifier = Modifier.size(100.dp)
                                            )
                                        }
                                        Button(
                                            onClick = { launcher.launch("image/*") },
                                            shape = RoundedCornerShape(size = 16.dp),
                                            modifier = Modifier.padding(top = 8.dp)
                                        ) {
                                            Text("Pilih Gambar")
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Button(
                        onClick = {
                            val baseUrl = "http://10.0.2.2:8080/formulir"
                            val params = "?nik=${nik.value}&nama=${nama.value}&jk=${jk.value}&tempat=${tempat.value}&tanggal=${tanggal.value}&alamat=${alamat.value}&rt=${rt.value}&rw=${rw.value}&agama=${agama.value}&type=${formConfig.title}"
                            val fullUrl = baseUrl + params

                            val stringRequest = object : StringRequest(
                                Request.Method.GET, fullUrl,
                                Response.Listener { response ->
                                    Log.d("RegisterResponse", "Response: $response")
                                    if (response == "\"SUCCESS\"") {
                                        Log.d("RegisterStatus", "Registration successful")
                                        navController.navigate("beranda")
                                    } else {
                                        Log.d("RegisterStatus", "Registration failed")
                                        Toast.makeText(context, "Pendaftaran gagal. Coba lagi.", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                Response.ErrorListener { error ->
                                    Log.e("RegisterError", "Error: ${error.message}")
                                    Toast.makeText(context, "Terjadi kesalahan saat melakukan pendaftaran.", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                override fun getBodyContentType(): String {
                                    return "application/json; charset=utf-8"
                                }
                            }

                            requestQueue.add(stringRequest)
                        },
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.buttonElevation(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0A2083)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Kirim",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DynamicFormPreview() {
    val navController = rememberNavController()
    val formFields = listOf(
        FormField(label = "Nama Lengkap", placeholder = "", inputType = InputType.TEXT),
        FormField(label = "NIK", placeholder = "", inputType = InputType.NUMBER),
        FormField(label = "Jenis Kelamin", placeholder = "", inputType = InputType.DROPDOWN),
        FormField(label = "Tempat Lahir", placeholder = "", inputType = InputType.TEXT),
        FormField(label = "Tanggal Lahir", placeholder = "", inputType = InputType.DATE),
        FormField(label = "Alamat", placeholder = "", inputType = InputType.TEXT),
        FormField(label = "Wilayah RT", placeholder = "", inputType = InputType.NUMBER),
        FormField(label = "Wilayah RW", placeholder = "", inputType = InputType.NUMBER),
        FormField(label = "Agama", placeholder = "", inputType = InputType.DROPDOWN),
        FormField(label = "Status Perkawinan", placeholder = "", inputType = InputType.DROPDOWN)
    )
    val formConfig = FormConfig(
        title = "Formulir Pengajuan Surat",  // Set the title here
        fields = formFields
    )

    DynamicForm(navController = navController, formConfig = formConfig)
}
