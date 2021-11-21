package com.example.currencyconverter.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Convert Currency Converted Screen TO COmpose
 * [MainComposeScreen]
 * 1. use [EnterAmountUI] for the Amount Edit Text Handle UI
 * 2. use [CurrencySpinnerSelection] as the spinner for the [currencyViewModel.cu]
 *
 */
@ExperimentalComposeUiApi
@Composable
fun MainComposeScreen(currencyViewModel: CurrViewModel) {
    //BackHandler(onBack = onBack)

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            EnterAmountUI(
                currencyViewModel.etAmountInputValue.observeAsState("1").value,
                "Enter Amount",
                currencyViewModel::onTextChange
            )
            //currencyViewModel.getCurrList()
            val curList = currencyViewModel.currListLiveDate.observeAsState().value
            //val curList by currencyViewModel.currListLiveDate.observeAsState()
            curList?.let { list ->
                CurrencySpinnerSelection(
                    list,
                    currencyViewModel.selectedCurrency.observeAsState("USD").value,
                    currencyViewModel::onSpinItemClick
                )

                ConversionRatesLazyColumn(
                    list,
                    currencyViewModel::getExchangeRateText
                )
            }

        }
}

@Composable
private fun ConversionRatesTexts(currList: List<String>, getExchangeRate: (Int) -> String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) //To Make Column Scrollable
    ) {
        currList.forEachIndexed { index, _ ->
            Text(
                text = getExchangeRate(
                    index
                ),
                fontSize = 22.sp
            )
        }
    }
}


@Composable
private fun ConversionRatesLazyColumn(
    currList: List<String>,
    getExchangeRate: (Int) -> String
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(items = currList) { index, _ ->
            Text(
                text = getExchangeRate(
                    index
                ),
                fontSize = 22.sp
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun EnterAmountUI(
    etState: String,
    etTitle: String = "Enter Amount",
    OnTextChange: (String) -> Unit
) {

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        ContentTextAmountField(
            label = etTitle,
            text = etState,//currViewModel.myEtAmountState.value,
            onTextChange = { newValue ->
                OnTextChange(newValue)
            }
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun ContentTextAmountField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    onTextChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(label) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        keyboardOptions =
        KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    )
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun EnterAmountUIPreview() {
    EnterAmountUI("", "Enter Amount", {})
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun CurrencySpinnerSelectionPreview() {
    CurrencySpinnerSelection(listOf("USD,EGP"), "USD", {})
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun MainConversionPreview() {

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            EnterAmountUI("", "Enter Amount") {}
            //currencyViewModel.getCurrList()
            val curList = listOf<String>("EGP", "USD")
            //val curList by currencyViewModel.currListLiveDate.observeAsState()
            curList?.let { list ->
                CurrencySpinnerSelection(
                    list,
                    "EGP"
                ) {}

                ConversionRatesLazyColumn(list) { "1 USD = 16 EGP" }
            }

        }
}

//@Preview
@Composable
fun CurrencySpinnerSelection(
    currList: List<String>,
    selectedCurr: String,
    OnSpinnerClicked: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        Row(
            Modifier
                .padding(2.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) { // Anchor view
            Text(
                text = selectedCurr,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 8.dp)
            ) // Country name label
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

            //
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                currList//currViewModel.currLis.value
                    .forEach { selectCurr ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            OnSpinnerClicked(selectCurr)
                        }) {
                            Text(text = selectCurr)
                        }
                    }
            }
        }
    }

}
