package com.example.visuda.model

data class Berita(
    val id: Int, // Add an id property
    val judul: String,
    val tanggal: String,
    val isi: String,
    val photo: Int // Explicitly declare as Int for drawable resource
)
