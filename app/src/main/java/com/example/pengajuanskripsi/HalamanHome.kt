package com.example.pengajuanskripsi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pengajuanskripsi.ui.theme.PengajuanSkripsiTheme

@Composable
fun HalamanHome(
    onNextButtonCliked: () -> Unit
) {
    val image = painterResource(id = R.drawable.logo_umy)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(painter = image, contentDescription = null, contentScale = ContentScale.Crop)
        
        Button(onClick = onNextButtonCliked) {
            Text(text = stringResource(id = R.string.masuk))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HalamanHome (onNextButtonCliked = {})
}