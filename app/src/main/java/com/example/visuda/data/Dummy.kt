package com.example.visuda.data


import com.example.visuda.R
import com.example.visuda.model.Berita
import com.example.visuda.model.FormConfig
import com.example.visuda.model.FormField
import com.example.visuda.model.InputType
import com.example.visuda.model.Kategori

object Dummy {
    val beritas = listOf(
        Berita(
            id = 1,
            judul = "Laporan Penggunaan Iuran Warga RT 002/RW 001",
            tanggal = "31/03/2024",
            isi = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas diam purus, cursus quis quam ac, mattis venenatis lorem. Cras ultricies vestibulum libero, quis porttitor dui.",
            photo = R.drawable.gbberita
        ),
        Berita(
            id = 2,
            judul = "Laporan Penggunaan Iuran Warga RT 003/RW 001",
            tanggal = "01/04/2024",
            isi = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas diam purus, cursus quis quam ac, mattis venenatis lorem. Cras ultricies vestibulum libero, quis porttitor dui.",
            photo = R.drawable.gbberita
        ),
        Berita(
            id = 3,
            judul = "Laporan Penggunaan Iuran Warga RT 004/RW 001",
            tanggal = "02/04/2024",
            isi = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas diam purus, cursus quis quam ac, mattis venenatis lorem. Cras ultricies vestibulum libero, quis porttitor dui.",
            photo = R.drawable.gbberita
        ),
        Berita(
            id = 4,
            judul = "Laporan Penggunaan Iuran Warga RT 005/RW 001",
            tanggal = "03/04/2024",
            isi = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas diam purus, cursus quis quam ac, mattis venenatis lorem. Cras ultricies vestibulum libero, quis porttitor dui.",
            photo = R.drawable.gbberita
        )
    )

    val kategoris = listOf(
        Kategori(
            id = 1,
            nama = "Surat Keterangan Domisili",
            photo = R.drawable.f1
        ),
        Kategori(
            id = 2,
            nama = "Surat Keterangan Nikah",
            photo = R.drawable.f2
        ),
        Kategori(
            id = 3,
            nama = "Surat Pengantar RT/RW",
            photo = R.drawable.f3
        ),
        Kategori(
            id = 4,
            nama = "Surat Pembuatan Kartu Keluarga",
            photo = R.drawable.f4
        ),
        Kategori(
            id = 5,
            nama = "Surat Keterangan Usaha",
            photo = R.drawable.f5
        ),
        Kategori(
            id = 6,
            nama = "Surat Kematian",
            photo = R.drawable.f6
        )
    )
}