@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pengajuanskripsi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun HalamanForm(
    pilihDosen:List<String>,
    //onSelectionChange: (String) -> Unit,
    onSubmitButtonCliked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txName by rememberSaveable { mutableStateOf("") }
    var txNim by rememberSaveable { mutableStateOf("") }
    var txkonsen by rememberSaveable { mutableStateOf("") }
    var txjudul by remember { mutableStateOf("") }
    var txDp1 by remember { mutableStateOf("") }
    var txDp2 by remember { mutableStateOf("") }

    var listDatatxt: MutableList<String> = mutableListOf(txName, txNim, txkonsen, txjudul, txDp1, txDp2)

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.form))
        OutlinedTextField(
            value = txName,
            label = { Text(text = stringResource(id = R.string.nama)) },
            onValueChange = {txName = it})
        OutlinedTextField(
            value = txNim,
            label = { Text(text = stringResource(id = R.string.nim)) },
            onValueChange = {txNim = it})
        OutlinedTextField(
            value = txkonsen,
            label = { Text(text = stringResource(id = R.string.kosentrasi)) },
            onValueChange = {txkonsen = it})
        OutlinedTextField(
            value = txjudul,
            label = { Text(text = stringResource(id = R.string.judul)) },
            onValueChange = {txjudul = it})

        Row {
            Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
                Text(text = stringResource(id = R.string.dospem1))
                pilihDosen.forEach {item ->
                    Row(modifier = Modifier.selectable(
                        selected = txDp1 == item,
                        onClick = {
                            txDp1 = item
                            //onSelectionChange(item)
                        }),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = txDp1 == item,
                            onClick = {
                                txDp1 == item
                                //onSelectionChange(item)
                            })
                        Text(text = item)
                    }
                }
            }
            Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
                Text(text = stringResource(id = R.string.dospem2))
                pilihDosen.forEach {item ->
                    Row(modifier = Modifier.selectable(
                        selected = txDp2 == item,
                        onClick = {
                            txDp2 = item
                            //onSelectionChange(item)
                        }),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = txDp2 == item,
                            onClick = {
                                txDp2 == item
                                //onSelectionChange(item)
                            })
                        Text(text = item)
                    }
                }
            }
        }

        Button(onClick = {onSubmitButtonCliked(listDatatxt)}) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}