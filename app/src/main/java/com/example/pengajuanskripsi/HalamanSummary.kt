package com.example.pengajuanskripsi

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pengajuanskripsi.data.SkripsiUIState

@Composable
fun HalamanSummary(
    SkripsiUIState: SkripsiUIState
) {
    val item = listOf(
        Pair(stringResource(id = R.string.nama), SkripsiUIState.nama),
    )
}