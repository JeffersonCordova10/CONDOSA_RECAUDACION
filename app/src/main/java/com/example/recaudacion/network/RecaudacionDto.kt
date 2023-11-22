package com.example.recaudacion.network

data class CuentaDTO(
    val idCuenta: Int,
)

data class MantenimientoReciboDTO(
    val idMantenimientoRecibo: Int,
)

data class TipoMonedaDTO(
    val idTipoMoneda: Int,
)

data class RecaudacionEstadoDTO(
    val idRecaudacionEstado: Int,
)

data class CuentaPredioDTO(
    val idCuentaPredio: Int,
)

data class RecaudacionDTO(
    val cuenta: CuentaDTO,
    val mantenimientoRecibo: MantenimientoReciboDTO,
    val noperacion: Long,
    val fechaOperacion: String,
    val tipoMoneda: TipoMonedaDTO,
    val importe: Double,
    val recaudacionEstado: RecaudacionEstadoDTO,
    val cuentaPredio: CuentaPredioDTO,
    val observacion: String
)
