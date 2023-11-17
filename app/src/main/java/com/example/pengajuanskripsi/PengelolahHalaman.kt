@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pengajuanskripsi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pengajuanskripsi.data.SumberData


enum class PengelolahHalaman {
    Home,
    Form,
    Summary
}

@Composable
fun PengajuanSkripsiApp(
    viewModel: PengajuanViewModel = PengajuanViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolahHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = PengelolahHalaman.Home.name) {
                HalamanHome(
                    onNextButtonCliked = {navController.navigate(PengelolahHalaman.Form.name)}
                )
            }
            composable(route = PengelolahHalaman.Form.name) {
                val  context = LocalContext.current
                HalamanForm(
                    pilihDosen = SumberData.dospem.map { id -> context.resources.getString(id) },
                    onSelectionChange = {},
                    onSubmitButtonCliked = { navController.navigate(PengelolahHalaman.Summary.name)})

            }
            composable(route = PengelolahHalaman.Summary.name){
                HalamanSummary(
                    SkripsiUIState = uiState,
                    onBackButtonCliked = {navController.popBackStack(PengelolahHalaman.Form.name, inclusive = false)})
            }
        }
    }
}