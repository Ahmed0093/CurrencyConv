package com.example.currencyconverter.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.currencyconverter.MainCoroutineRule
import com.example.currencyconverter.repository.CurrRepo
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.math.BigDecimal

class CurrViewModelTest {

    private lateinit var currViewModel: CurrViewModel
    private lateinit var currRepo: CurrRepo

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        currRepo = mock { CurrRepo() }
        currViewModel = CurrViewModel(currRepo)
    }


    @Test
    fun ` if SelectedCurrency is USD Check Conversion Items by position`() {
        currViewModel.selectedCurr = "USD"
        currViewModel.amountEnteredByUser = BigDecimal.ONE
        val mockCurrMap = getMockCurrMap()

        assertEquals(
            currViewModel.getExchangeRateText(0, mockCurrMap), "1 USD = 3.6700 AED"
        )
        assertEquals(
            currViewModel.getExchangeRateText(1, mockCurrMap), "1 USD = 15.6800 EGP"
        )
        assertEquals(
            currViewModel.getExchangeRateText(2, mockCurrMap), "1 USD = 0.8200 EUR"
        )
        assertEquals(
            currViewModel.getExchangeRateText(3, mockCurrMap), "1 USD = 108.9200 JPY"
        )
        assertEquals(
            currViewModel.getExchangeRateText(4, mockCurrMap), "1 USD = 1.0000 USD"
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun checkCurrRepoCallWhenCallGetCurrListFromVIewModel() = mainCoroutineRule.runBlockingTest {
        currViewModel.getCurrList()
        verify(currRepo, times(1)).getCurrResponse()
    }


    fun getMockCurrMap(): LinkedHashMap<String, Double> {
        val currListMap = LinkedHashMap<String, Double>()
        currListMap.put("AED", 3.67)
        currListMap.put("EGP", 15.68)
        currListMap.put("EUR", 0.82)
        currListMap.put("JPY", 108.92)
        currListMap.put("USD", 1.0)
        return currListMap
    }

}