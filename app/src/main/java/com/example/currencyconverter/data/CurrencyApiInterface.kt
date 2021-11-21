package com.example.currencyconverter.data

import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApiInterface {

    @GET("live?access_key=6b55a0935512b74c7f872b38d8006182")
    suspend fun getCurrResponse(): Response<CurrResposneModel>
}