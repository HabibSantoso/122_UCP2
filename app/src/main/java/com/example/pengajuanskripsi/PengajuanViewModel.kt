package com.example.pengajuanskripsi

import androidx.lifecycle.ViewModel
import com.example.pengajuanskripsi.data.SkripsiUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PengajuanViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(SkripsiUIState())
    val stateUI:StateFlow<SkripsiUIState> = _stateUI.asStateFlow()

    fun resetPengajuan() {
        _stateUI.value = SkripsiUIState()
    }

    fun setPengajuan(listData: MutableList<String>) {
        _stateUI.update { statesaatini ->
            statesaatini.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judul = listData[3],
                dospem1 = listData[4],
                dospem2 = listData[5]
            )
        }
    }
}