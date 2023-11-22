package com.example.recaudacion.network

import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL =
    "https://condosa-recaudacion-production.up.railway.app/api/v1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .client(OkHttpClient.Builder().build())
    .build()

interface CollectionsApiService {

    @GET("recaudacion")
    suspend fun getCollections(): List<Recaudacion>

    @GET("cuenta/persona_nroDocumento/{nroDocumento}")
    suspend fun getCuenta(@Path("nroDocumento") nroDocumento: String): InformacionPersonal

    @GET("predio/predio_ruc/{ruc}")
    suspend fun getPredio(@Path("ruc") ruc: String): Predio

    @GET("mant_recibo/nro_recibo/recaudacion/{recibo}")
    suspend fun getMantenimientoRecibo(@Path("recibo") recibo: String): MantenimientoRecibo

    @POST("recaudacion/guardar")
    suspend fun guardarRecaudacion(@Body recaudacion: RecaudacionDTO): Response<ResponseBody>

    @POST("cuenta")
    suspend fun guardarCuenta(@Body cuenta: CuentaPersonaDTO): Response<ResponseBody>
}

object CollectionsApi {
    val retrofitService : CollectionsApiService by lazy {
        retrofit.create(CollectionsApiService::class.java)
    }
}
