package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.ui.CurrAdapter
import com.example.currencyconverter.ui.CurrViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    lateinit var currViewModel: CurrViewModel
    lateinit var currAdapter: CurrAdapter
    var selectedCurr = "USD"
    var currList: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currViewModel = ViewModelProvider(this).get(CurrViewModel::class.java)
        currViewModel.selectedCurr = selectedCurr

        currViewModel.getCurrList()

        currViewModel.currResponseModelLiveDataUiState.observe(
            this, Observer { currResponse ->
                currAdapter.setCurrencyMap(currResponse.quotes.getCurrListAsMap())
                initSpinner()

            })
        initAdapter()
        initListenr()
    }

    private fun initListenr() {
        edtText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(value: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally left blank
            }

            override fun afterTextChanged(s: Editable?) {
                s.toString().toBigDecimalOrNull()?.let {
                    currViewModel.amountEnteredByUser = it
                    currAdapter.notifyDataSetChanged()
                }
                if (s.toString().isEmpty()) {
                    currViewModel.amountEnteredByUser = BigDecimal.ONE
                    currAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun initAdapter() {
        currAdapter = CurrAdapter(
            currViewModel
        )

        cur_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cur_rv.setHasFixedSize(true)
        cur_rv.adapter = currAdapter
    }

    private fun initSpinner() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (currList == null) {
            currList =
                currViewModel.currResponseModel?.quotes?.getCurrListAsMap()?.keys?.toTypedArray() //arrayOf("USD", "AUD", "EGP")
            val adapter =
                ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    currList as Array<out String>
                )

            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    arg0: AdapterView<*>?,
                    arg1: View?,
                    arg2: Int,
                    arg3: Long
                ) {
                    // Do what you want
                    selectedCurr = spinner.selectedItem.toString()
                    //currAdapter.setSelectedCurr(selectedCurr)
                    currViewModel.selectedCurr = selectedCurr
                    currAdapter.notifyDataSetChanged()


                }

                override fun onNothingSelected(arg0: AdapterView<*>?) {}
            }
        }
    }
}