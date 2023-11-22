package com.example.recaudacion.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recaudacion.network.CollectionsApi
import com.example.recaudacion.network.RecaudacionState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/*sealed interface CollectionsUiState {
    data class Success(val collections: List<Recaudacion>) : CollectionsUiState
    object Error : CollectionsUiState
    object Loading : CollectionsUiState
}*/

class MenuPrincipalViewModel : ViewModel() {
    var collectionsUiState by mutableStateOf(RecaudacionState())
        private set

    init {
        getCollections()
    }

    private fun getCollections() {
        viewModelScope.launch {
            try {
                val listResult = CollectionsApi.retrofitService.getCollections()
                //Log.d("GetCollections","se trajo la data")
                collectionsUiState = collectionsUiState.copy(
                    recaudaciones = listResult
                )
            } catch (e: IOException) {
                //Log.d("GetCollections","Error : ${e}")
            } catch (e: HttpException){
                //Log.d("GetCollections","Error : ${e}")
            }
        }
    }
}
