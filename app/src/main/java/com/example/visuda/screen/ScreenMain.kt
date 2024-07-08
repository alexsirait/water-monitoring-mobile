package com.example.visuda.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.visuda.components.BottomBar
import com.example.visuda.navigation.Routes
import com.example.visuda.screen.LandingPage
import com.example.visuda.utils.Utils

@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val notshow = currentRoute !in Utils.listScreenWithoutBottomBar

    Scaffold(
        bottomBar = {
            if (notshow) {
                        BottomBar(navController = navController)
            }
        },
        modifier = Modifier
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Routes.Landing.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Routes.Landing.route) {
                LandingPage(navController = navController)
            }
            composable(Routes.Login.route) {
                LoginPage(navController = navController)
            }
            composable(Routes.Daftar.route) {
                DaftarPage(navController = navController)
            }
            composable(Routes.Dashboard.route) {
                DashboardPage(navController = navController)
            }
            composable(Routes.Beranda.route) {
                BerandaPage(navController = navController)
            }
            composable(Routes.Beranda.route) {
                BerandaPage(navController = navController)
            }
            composable(Routes.Riwayat.route) {
                RiwayatPage(navController = navController)
            }
            composable(Routes.Notifikasi.route) {
                NotifikasiPage(navController = navController)
            }
            composable(Routes.Profile.route) {
                ProfilePage(navController = navController)
            }
            composable(Routes.DaftarSurat.route) {
                DaftarSuratPage(navController = navController)
            }
            composable(Routes.Formulir.route) {
                FormulirPage(navController = navController)
            }
            composable(Routes.DataKeluarga.route) {
                DataKeluargaPage(navController = navController)
            }
            composable(Routes.TambahData.route) {
                TambahDataPage(navController = navController)
            }
            composable(Routes.EditProfile.route) {
                EditProfilePage(navController = navController)
            }
            composable(
                route = Routes.FormulirPage.route,
                arguments = listOf(navArgument("suratType") { type = NavType.StringType })
            ) { backStackEntry ->
                val suratType = backStackEntry.arguments?.getString("suratType") ?: return@composable
                FormulirPage(navController, suratType)
            }
            composable(Routes.TentangKami.route) {
                TentangKami(navController = navController)
            }
        }
    }
}