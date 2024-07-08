package com.example.visuda.navigation

sealed class Routes (val route:String){
    object Login : Routes("Login")
    object Landing : Routes("Landing")
    object Daftar : Routes("Daftar")
    object Dashboard : Routes("Dashboard")
    object Beranda : Routes("Beranda")
    object Riwayat : Routes("Riwayat")
    object Notifikasi : Routes("Notifikasi")
    object Profile : Routes("Profile")
    object DaftarSurat : Routes("DaftarSurat")
    object Formulir : Routes("Formulir")
    object DataKeluarga : Routes("DataKeluarga")
    object TambahData : Routes("TambahData")
    object EditProfile : Routes("EditProfile")

    object FormulirPage : Routes("FormulirPage/{suratType}") {
        fun createRoute(suratType: String) = "FormulirPage/$suratType"
    }
    object TentangKami : Routes("TentangKami")


}