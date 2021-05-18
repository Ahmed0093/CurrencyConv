package com.example.currencyconverter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.CurrResposneModel
import com.example.currencyconverter.network.ResultType
import com.example.currencyconverter.repository.CurrRepo
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode

class CurrViewModel
    (private val currRepo: CurrRepo = CurrRepo()) : ViewModel() {

    var currResponseModel: CurrResposneModel? = null
    var amountEnteredByUser: BigDecimal? = BigDecimal.ONE
    var selectedCurr: String? = "USD"
    private val currResponseModelLiveData = MutableLiveData<CurrResposneModel>()
    val currResponseModelLiveDataUiState: LiveData<CurrResposneModel> = currResponseModelLiveData


    fun getCurrList() {
        viewModelScope.launch {
            val result = currRepo.getCurrResponse()
            when (result) {
                is ResultType.Success -> {
                    if (result.data is CurrResposneModel) {
                        currResponseModel = (result.data)
                        currResponseModelLiveData.value = currResponseModel
                    }
                }
                is ResultType.Error -> currResponseModelLiveData.value = null
            }
        }

    }

   private fun getLocalExchangeRateValue(position: Int, currMap: HashMap<String, Double>?): BigDecimal? {
        val currencyMap = currMap
        val currencyByPosition =
                currencyMap?.keys?.toTypedArray()?.get(position) as String
        val convFactor: BigDecimal? = currencyMap?.get(selectedCurr)?.toBigDecimal()
        convFactor?.let {
            return currencyMap[currencyByPosition]?.toBigDecimal()
                    ?.divide(convFactor, 4, RoundingMode.CEILING)
                    ?.multiply(amountEnteredByUser)
        }
        return null
    }

    fun getExchangeRateText(position: Int, currMap: HashMap<String, Double>?): String {
        val convertedCurrency = currMap?.keys?.toTypedArray()?.get(position) as String
        val exchangeRateValue: BigDecimal? = getLocalExchangeRateValue(position,currMap)
        return "$amountEnteredByUser $selectedCurr = $exchangeRateValue $convertedCurrency"
    }
}