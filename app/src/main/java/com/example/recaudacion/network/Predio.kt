package com.example.recaudacion.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Predio(
    @SerialName("idCuentaPredio") val idCuentaPredio: Int,
    @SerialName("nombre") val nombre: String,
    @SerialName("dirrecion") val dirrecion: String,
    @SerialName("tipoDePredio") val tipoDePredio: String,
    @SerialName("nrCuentaPredio") val nrCuentaPredio: Long,
    @SerialName("tipoAutorizacion") val tipoAutorizacion: String,
    @SerialName("estado") val estado: String
)
