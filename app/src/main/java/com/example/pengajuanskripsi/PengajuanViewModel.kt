package com.example.pengajuanskripsi

import androidx.lifecycle.ViewModel
import com.example.pengajuanskripsi.data.SkripsiUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PengajuanViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(SkripsiUIState())
    val stateUI:StateFlow<SkripsiUIState> = _stateUI.asStateFlow()

    fun resetPengajuan() {
        _stateUI.value = SkripsiUIState()
    }
}