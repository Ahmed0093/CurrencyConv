package com.example.currencyconverter.ui

import androidx.compose.runtime.*
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

    var currMap: LinkedHashMap<String, Double>? = null
    val etAmountInputValue = MutableLiveData("1")
    var selectedCurrency = MutableLiveData("USD") // FOR COMPOSE

    //---------STATE----------
    //1. USE LIVE DATA To Reuse OLD CODE !!
    //need to add livedata dependency and use observaeAsSTATE
    // this used in both Code and can use Same Concept
    // when migrate MVVM APP USING LIVE DATA DATABINDING
    private val currListLiveData = MutableLiveData<List<String>>()
    val currListLiveDate: LiveData<List<String>>
        get() = currListLiveData

    //2. USE MutableState !! NOT USED tHIS APPROACH NOW
    // state: CurrList
    //State<T>
//A type that holds a read-only value: T and notifies
// the composition (and other “snapshot observers”, like layouts) when value changes.
    private val _currLis = mutableStateOf(emptyList<String>()) // 1
    val currLis: State<List<String>> = _currLis // 2


    fun getCurrList() {
        if (currListLiveData.value == null) {
            viewModelScope.launch {
                when (val result = currRepo.getCurrResponse()) {
                    is ResultType.Success -> {
                        if (result.data is CurrResposneModel) {
                            currMap = result.data?.quotes?.getCurrListAsMap()
                            currListLiveData.value = //To Test LiveDataMutableState
                                (currMap?.keys?.toList()
                                    ?: listOf("EGP", "AED"))
                        }
                    }
                    is ResultType.Error -> currListLiveData.value =
                        listOf("USD", "AED") // SHOW 2 CURR FOR ERROR
                }
            }
        }

    }

    private fun getLocalExchangeRateValue(
        position: Int,
        currMap: HashMap<String, Double>?
    ): BigDecimal? {
        val currencyMap = currMap
        val currencyByPosition =
            currencyMap?.keys?.toTypedArray()?.get(position) as String
        val convFactor: BigDecimal? = currencyMap?.get(selectedCurrency.value)?.toBigDecimal()
        convFactor?.let {
            return currencyMap[currencyByPosition]?.toBigDecimal()
                ?.divide(convFactor, 4, RoundingMode.CEILING)
                ?.multiply(etAmountInputValue.value?.toBigDecimalOrNull() ?: BigDecimal.ONE)
        }
        return null
    }

    fun getExchangeRateText(position: Int): String {
        val convertedCurrency = currMap?.keys?.toTypedArray()?.get(position) as String
        val exchangeRateValue: BigDecimal? = getLocalExchangeRateValue(position, currMap)
        return "${(etAmountInputValue.value)} ${(selectedCurrency.value)} = $exchangeRateValue $convertedCurrency"
    }

    fun onTextChange(updatedText: String) {
        etAmountInputValue.value = updatedText.filter { it.isDigit() }
    }

    fun onSpinItemClick(country: String) {
        selectedCurrency.value = country
        //Encapsulate State in ViewModel !!
    }
}