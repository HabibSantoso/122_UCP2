package com.example.pengajuanskripsi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.pengajuanskripsi.data.SkripsiUIState

@Composable
fun HalamanSummary(
    SkripsiUIState: SkripsiUIState,
    onBackButtonCliked: () -> Unit
) {
    val items = listOf(
        Pair(stringResource(id = R.string.nama), SkripsiUIState.nama),
        Pair(stringResource(id = R.string.nim), SkripsiUIState.nim),
        Pair(stringResource(id = R.string.kosentrasi), SkripsiUIState.konsentrasi),
        Pair(stringResource(id = R.string.judul), SkripsiUIState.judul),
        Pair(stringResource(id = R.string.dospem1), SkripsiUIState.dospem1),
        Pair(stringResource(id = R.string.dospem2), SkripsiUIState.dospem2),
    )

    Column (
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ){
        items.forEach { item ->
            Column {
                Text(item.first.uppercase())
                Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
            }
            Divider(thickness = dimensionResource(R.dimen.thikness_diveder))
        }
        Button(onClick = onBackButtonCliked) {
            Text(text = "Back")
        }
    }
}