package com.example.visuda.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.visuda.R
import com.example.visuda.model.Berita
import com.example.visuda.ui.theme.VisudaTheme

@Composable
fun BeritaItem(
    berita: Berita,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onItemClicked: (Berita) -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onItemClicked(berita) }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = berita.judul,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = berita.tanggal,
                style = TextStyle(
                    fontSize = 14.sp,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BeritaItemHorizontalPreview() {
    VisudaTheme {
        val fakeNavController = rememberNavController()
        BeritaItem(
            berita = Berita(1, "Reza Kurniawan", "Reza", "Mobile", R.drawable.gbberita),
            modifier = Modifier,
            navController = fakeNavController,
            onItemClicked = { beritaId ->
                println("Berita Id : $beritaId")
            }
        )
    }
}