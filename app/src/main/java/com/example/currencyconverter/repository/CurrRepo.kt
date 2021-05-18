package com.example.currencyconverter.repository

import com.example.currencyconverter.data.CurrResposneModel
import com.example.currencyconverter.data.CurrencyApiInterface
import com.example.currencyconverter.network.NetworkRoute.makeApiCall
import com.example.currencyconverter.network.ResultType
import com.example.currencyconverter.network.networkModuleProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrRepo {
    private val currencyApiInterface: CurrencyApiInterface by lazy {
        networkModuleProvider.providesRetrofit().create(
            CurrencyApiInterface::class.java
        )
    }

    suspend fun getCurrResponse(): ResultType<CurrResposneModel> {
        return withContext(Dispatchers.IO) {
            makeApiCall {
                currencyApiInterface.getCurrResponse()
            }
        }
    }
}