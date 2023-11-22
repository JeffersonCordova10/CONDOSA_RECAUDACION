package com.example.recaudacion.ui.screens

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toUpperCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recaudacion.network.CollectionsApi
import com.example.recaudacion.network.CuentaDTO
import com.example.recaudacion.network.CuentaPersonaDTO
import com.example.recaudacion.network.RecaudacionDTO
import com.example.recaudacion.network.RegistroState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RegistroViewModel : ViewModel() {
    var registerUiState by mutableStateOf(RegistroState())
        private set

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> = _errorMessage

    fun clearErrorMessage() {
        _errorMessage.value = ""
    }

    fun getMantenimientoReciboPorNroRecibo(nroRecibo : TextFieldValue){
        viewModelScope.launch {
            try {
                val result = CollectionsApi.retrofitService.getMantenimientoRecibo(nroRecibo.text.toUpperCase())
                Log.d("Resultado","${result}")
                registerUiState = registerUiState.copy(
                    // Mantenimiento del recibo
                    idMantRecibo = result.idMantRecibo.toInt(),
                    estadoRecibo = result.estadoRecibo,
                    importeRecibo = result.importe,
                    idCuenta = if (result.idCuenta == 0) -1 else result.idCuenta,
                    idPersona = result.idPersona,
                    nombre = result.nombre,
                    idTipoMoneda = result.idTipoMoneda.toInt(),
                    idCuentaPredio = result.idCuentaPredio.toInt()

                )
            } catch (e: IOException) {
                _errorMessage.value = "Error de red. Inténtelo de nuevo más tarde."
            } catch (e: HttpException) {
                if (e.code() == 500) {
                    _errorMessage.value = "Error interno en el servidor."
                } else if (e.code() == 404){
                    _errorMessage.value = "El nro de recibo no existe."
                } else {
                    _errorMessage.value = "Ha ocurrido un error. Inténtelo de nuevo más tarde."
                }
            }
        }
    }

    fun guardarRecaudacion(recaudacionDTO: RecaudacionDTO){
        viewModelScope.launch {
            try {
                val response = CollectionsApi.retrofitService.guardarRecaudacion(recaudacionDTO)
                Log.d("Se guarda la recaudacion"," ${response}")
            } catch (e: IOException) {
                _errorMessage.value = "Error de red. Inténtelo de nuevo más tarde."
            } catch (e: HttpException) {
                if (e.code() == 500) {
                    _errorMessage.value = "No se encontró el recibo."
                }
            }
        }
    }

    fun guardarCuenta(cuentaDTO: CuentaPersonaDTO){
        viewModelScope.launch {
            try {
                val response = CollectionsApi.retrofitService.guardarCuenta(cuentaDTO)
                Log.d("Se guarda la cuenta"," ${response}")
            } catch (e: IOException){
                _errorMessage.value = "Error de red. Inténtelo de nuevo más tarde."
            } catch (e: HttpException) {
                _errorMessage.value = "No se pudo registrar la cuenta"
            }
        }
    }

}