package com.example.currencyconverter

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.ui.*
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
/**
 * Add Compose to already Existing Old Project
 * [addComposeUIToOldFeature]
 * 1. make the [MainActivity] extends [ComponentActivity]
 * 2. add [my_composable] as Compose View in XML
 * UnComment the Oncreate for Compose to
 * Run the Compose Converted Screen !
 */

class MainActivity : ComponentActivity() {
    lateinit var currViewModel: CurrViewModel
    lateinit var currAdapter: CurrAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //--Add Compose TO OLD Feature
        addComposeUIToOldFeature()

        currViewModel = ViewModelProvider(this).get(CurrViewModel::class.java)
        currViewModel.getCurrList()
        currViewModel.currListLiveDate.observe(
            this, { currList ->
                initSpinner(currList)

            })
        initAdapter()
        initListener()
    }

    private fun addComposeUIToOldFeature() {
        findViewById<ComposeView>(R.id.my_composable).setContent {
            MaterialTheme {
                Text(text = "Hello from compose view!")
            }
        }
    }
//---- Start COMPOSE ONCREATE------
//@ExperimentalComposeUiApi
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    currViewModel = ViewModelProvider(this).get(CurrViewModel::class.java)
//    currViewModel.getCurrList()
//    setContent {
//        MainComposeScreen(currViewModel)
//    }
//}
//---- End COMPOSE ONCREATE------

    private fun initListener() {
        textview.setOnClickListener{
            val intent = Intent(this, MainComposeActivity::class.java)
            startActivity(intent)

        }
        edtText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(value: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Intentionally left blank
            }

            override fun afterTextChanged(s: Editable?) {
                s.toString().toBigDecimalOrNull()?.let {
                    currViewModel.onTextChange(it.toString())
                    currAdapter.notifyDataSetChanged()
                }
                if (s.toString().isEmpty()) {
                    currViewModel.onTextChange(BigDecimal.ONE.toString())
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

    private fun initSpinner(currList: List<String>) {
        val spinner = findViewById<Spinner>(R.id.spinner)

        val adapter =
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                currList.toTypedArray() as Array<out String>
            )

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                arg0: AdapterView<*>?,
                arg1: View?,
                arg2: Int,
                arg3: Long
            ) {
                currViewModel.onSpinItemClick(spinner.selectedItem.toString())
                currAdapter.notifyDataSetChanged()

            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {}
        }
    }
}