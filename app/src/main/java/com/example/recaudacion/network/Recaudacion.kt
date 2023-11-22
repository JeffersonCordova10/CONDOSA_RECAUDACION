package com.example.recaudacion.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recaudacion(
    @SerialName("idRecaudacion") val idRecaudacion: Int,
    @SerialName("fechaOperacion") val fechaOperacion: String,
    @SerialName("nombre") val nombre: String,
    @SerialName("predio") val predio: String,
    @SerialName("importe") val importe: Double,
    @SerialName("estado") val estado: String,
    @SerialName("noperacion") val noperacion: Long
)
