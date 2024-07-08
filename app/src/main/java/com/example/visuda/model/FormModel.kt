package com.example.visuda.model

data class FormField(
    val label: String,
    val placeholder: String,
    val inputType: InputType,
)

enum class InputType {
    TEXT, NUMBER, DROPDOWN, DATE, IMAGE
}

data class FormConfig(
    val title: String,
    val fields: List<FormField>
)

val formPermintaanSuratDomisiliConfig = FormConfig( "Permintaan Surat Domisili",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("NIK", "Masukkan NIK", InputType.NUMBER),
        FormField("Jenis Kelamin", "Pilih Jenis Kelamin", InputType.DROPDOWN),
        FormField("Tempat Lahir", "Masukkan Tempat Lahir", InputType.TEXT),
        FormField("Tanggal Lahir", "Masukkan Tanggal Lahir", InputType.DATE),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Wilayah RT", "Masukkan Wilayah RT", InputType.TEXT),
        FormField("Wilayah RW", "Masukkan Wilayah RW", InputType.TEXT),
        FormField("Agama", "Pilih Agama", InputType.DROPDOWN),
        FormField("Status Perkawinan", "Pilih Status Perkawinan", InputType.DROPDOWN),
        FormField("Foto Wajah", "Unggah Foto Wajah", InputType.IMAGE),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE),
        FormField("Scan KK", "Unggah Scan KK", InputType.IMAGE),
        FormField("Scan Surat Pengantar RT/RW", "Unggah Scan Surat Pengantar RT/RW", InputType.IMAGE)
    )
)

val formPermintaanSuratKeteranganNikahConfig = FormConfig( "Permintaan Surat KeteranganNikah",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("NIK", "Masukkan NIK", InputType.NUMBER),
        FormField("Jenis Kelamin", "Pilih Jenis Kelamin", InputType.DROPDOWN),
        FormField("Tempat Lahir", "Masukkan Tempat Lahir", InputType.TEXT),
        FormField("Tanggal Lahir", "Masukkan Tanggal Lahir", InputType.DATE),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Wilayah RT", "Masukkan Wilayah RT", InputType.TEXT),
        FormField("Wilayah RW", "Masukkan Wilayah RW", InputType.TEXT),
        FormField("Agama", "Pilih Agama", InputType.DROPDOWN),
        FormField("Status Perkawinan", "Pilih Status Perkawinan", InputType.DROPDOWN),
        FormField("Foto Wajah", "Unggah Foto Wajah", InputType.IMAGE),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE),
        FormField("Scan KK", "Unggah Scan KK", InputType.IMAGE),
        FormField("Scan Surat Pengantar RT/RW", "Unggah Scan Surat Pengantar RT/RW", InputType.IMAGE),
        FormField("Scan KTP Orangtua", "Unggah Scan KTP Orangtua", InputType.IMAGE),
        FormField("Scan Akta Kelahiran", "Unggah Scan Akta Kelahiran", InputType.IMAGE),
        FormField("Scan Surat Pernyataan Belum Menikah", "Unggah Scan Surat Pernyataan Belum Menikah", InputType.IMAGE),
        FormField("Scan Surat Izin Menumpang Nikah", "Unggah Scan Surat Izin Menumpang Nikah", InputType.IMAGE)
    )
)

val formPermintaanSuratPengantarRTRWConfig = FormConfig( "Permintaan Surat Pengantar RT RW",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("NIK", "Masukkan NIK", InputType.NUMBER),
        FormField("Jenis Kelamin", "Pilih Jenis Kelamin", InputType.DROPDOWN),
        FormField("Tempat Lahir", "Masukkan Tempat Lahir", InputType.TEXT),
        FormField("Tanggal Lahir", "Masukkan Tanggal Lahir", InputType.DATE),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Wilayah RT", "Masukkan Wilayah RT", InputType.TEXT),
        FormField("Wilayah RW", "Masukkan Wilayah RW", InputType.TEXT),
        FormField("Agama", "Pilih Agama", InputType.DROPDOWN),
        FormField("Profesi", "Masukkan Profesi", InputType.TEXT),
        FormField("Status Perkawinan", "Pilih Status Perkawinan", InputType.DROPDOWN),
        FormField("Keperluan Surat", "Masukkan Keperluan Surat", InputType.TEXT),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE),
        FormField("Scan KK", "Unggah Scan KK", InputType.IMAGE)
    )
)

val formPermintaanSuratPembuatanKKConfig = FormConfig( "Permintaan Surat Pembuatan KK",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("No KK Semula", "Masukkan No KK Semula", InputType.TEXT),
        FormField("NIK", "Masukkan NIK", InputType.NUMBER),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Wilayah RT", "Masukkan Wilayah RT", InputType.TEXT),
        FormField("Wilayah RW", "Masukkan Wilayah RW", InputType.TEXT),
        FormField("Desa", "Masukkan Desa", InputType.TEXT),
        FormField("Kecamatan", "Masukkan Kecamatan", InputType.TEXT),
        FormField("Kabupaten/Kota", "Masukkan Kabupaten/Kota", InputType.TEXT),
        FormField("Provinsi", "Masukkan Provinsi", InputType.TEXT),
        FormField("Kode Pos", "Masukkan Kode Pos", InputType.TEXT),
        FormField("No.Telp", "Masukkan No.Telp", InputType.TEXT),
        FormField("Alasan Permohonan", "Masukkan Alasan Permohonan", InputType.TEXT),
        FormField("Jumlah Anggota Keluarga", "Masukkan Jumlah Anggota Keluarga", InputType.NUMBER),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE)
    )
)

val formPermintaanSuratKeteranganUsahaConfig = FormConfig( "Permintaan Surat Keterangan Usaha",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("NIK", "Masukkan NIK", InputType.NUMBER),
        FormField("Jenis Kelamin", "Pilih Jenis Kelamin", InputType.DROPDOWN),
        FormField("Tempat & Tanggal Lahir", "Masukkan Tempat & Tanggal Lahir", InputType.DATE),
        FormField("Warganegara", "Masukkan Warganegara", InputType.TEXT),
        FormField("Agama", "Pilih Agama", InputType.DROPDOWN),
        FormField("Pekerjaan", "Masukkan Pekerjaan", InputType.TEXT),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Nama Usaha", "Masukkan Nama Usaha", InputType.TEXT),
        FormField("Mulai Usaha", "Masukkan Mulai Usaha", InputType.TEXT),
        FormField("Alamat Usaha", "Masukkan Alamat Usaha", InputType.TEXT),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE)
    )
)

val formPermintaanSuratKeteranganKematianConfig = FormConfig( "Permintaan Surat Keterangan Kematian",
    fields = listOf(
        FormField("Nama Lengkap", "Masukkan Nama Lengkap", InputType.TEXT),
        FormField("Bin / Binti", "Masukkan Bin / Binti", InputType.TEXT),
        FormField("Jenis Kelamin", "Pilih Jenis Kelamin", InputType.DROPDOWN),
        FormField("Agama", "Pilih Agama", InputType.DROPDOWN),
        FormField("Tempat & Tanggal Lahir", "Masukkan Tempat & Tanggal Lahir", InputType.DATE),
        FormField("Alamat", "Masukkan Alamat", InputType.TEXT),
        FormField("Tanggal Kematian", "Masukkan Tanggal Kematian", InputType.DATE),
        FormField("Jam Kematian", "Masukkan Jam Kematian", InputType.TEXT),
        FormField("Usia", "Masukkan Usia", InputType.NUMBER),
        FormField("Sebab Meninggal", "Masukkan Sebab Meninggal", InputType.TEXT),
        FormField("Lokasi Meninggal", "Masukkan Lokasi Meninggal", InputType.TEXT),
        FormField("Scan KTP", "Unggah Scan KTP", InputType.IMAGE)
    )
)