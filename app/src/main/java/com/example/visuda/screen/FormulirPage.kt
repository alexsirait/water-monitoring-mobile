package com.example.visuda.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.visuda.components.DynamicForm
import com.example.visuda.model.formPermintaanSuratDomisiliConfig
import com.example.visuda.model.formPermintaanSuratKeteranganKematianConfig
import com.example.visuda.model.formPermintaanSuratKeteranganNikahConfig
import com.example.visuda.model.formPermintaanSuratKeteranganUsahaConfig
import com.example.visuda.model.formPermintaanSuratPembuatanKKConfig
import com.example.visuda.model.formPermintaanSuratPengantarRTRWConfig

@Composable
fun FormulirPage(navController: NavHostController, suratType: String) {
    val formConfig = when (suratType) {
        "Surat Keterangan Domisili" -> formPermintaanSuratDomisiliConfig
        "Surat Keterangan Nikah" -> formPermintaanSuratKeteranganNikahConfig
        "Surat Pengantar RTRW" -> formPermintaanSuratPengantarRTRWConfig
        "Surat Pembuatan Kartu Keluarga" -> formPermintaanSuratPembuatanKKConfig
        "Surat Keterangan Usaha" -> formPermintaanSuratKeteranganUsahaConfig
        "Surat Kematian" -> formPermintaanSuratKeteranganKematianConfig
        else -> null
    }

    if (formConfig != null) {
        DynamicForm(navController, formConfig = formConfig)
    } else {
        Text("Form tidak tersedia")
    }
}
