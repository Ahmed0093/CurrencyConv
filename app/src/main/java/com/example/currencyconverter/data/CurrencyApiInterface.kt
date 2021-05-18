package com.example.currencyconverter.data

import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApiInterface {

    @GET("live?access_key=b1c81ff14ed9254364765492dca00058")
    suspend fun getCurrResponse(): Response<CurrResposneModel>
}