package com.example.recaudacion.network


data class PersonaDTO(
    val idPersona: Int,
)

data class BancoDTO(
    val idBanco: Int,
)

data class CuentaPersonaDTO(
    val persona: PersonaDTO,
    val banco: BancoDTO,
    val tipoMoneda: TipoMonedaDTO,
    val ncuenta: Long
)