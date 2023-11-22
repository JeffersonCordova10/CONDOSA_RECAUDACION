package com.example.recaudacion.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigInteger

data class MantenimientoRecibo(
    // Cuenta
    @SerialName("idCuenta") val idCuenta: Int,
    @SerialName("nombreCuenta") val nombreCuenta: String,
    @SerialName("banco") val banco: String,
    @SerialName("idTipoMoneda") val idTipoMoneda : Integer,
    @SerialName("moneda") val moneda: String,
    @SerialName("nCuenta") val nCuenta: Long,

    // Persona
    @SerialName("nombre") val nombre: String,
    @SerialName("idPersona") val idPersona: Int,

    // Cuenta predio
    @SerialName("idCuentaPredio") val idCuentaPredio: Integer,
    @SerialName("nombrePredio") val nombrePredio: String,
    @SerialName("dirrecion") val dirrecion: String,
    @SerialName("tipoDePredio") val tipoDePredio: String,
    @SerialName("nrCuentaPredio") val nrCuentaPredio: Long,
    @SerialName("tipoAutorizacion") val tipoAutorizacion: String,
    @SerialName("estado") val estado: String,

    // Mantenimiento recibo
    @SerialName("idMantRecibo") val idMantRecibo: Integer,
    @SerialName("estadoRecibo") val estadoRecibo: String,
    @SerialName("importe") val importe: Double
)