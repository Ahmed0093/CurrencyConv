package com.example.currencyconverter.ui

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.currencyconverter.R
import com.example.currencyconverter.data.MovieModel
import com.example.currencyconverter.ui.ui.theme.Purple200
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ComposeSamples {

    @Preview(showBackground = true)
    @Composable
    fun DynamicComposable(strings: List<String>? = listOf("st1", "st2", "st3")) {
        if (strings.isNullOrEmpty()) {
            Text(text = "empty")
        } else {
            strings?.forEach {
                Text(text = it)
            }
        }
    }
}



@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = Purple200,//colorResource(id = R.color.purple_200),
        contentColor = Color.White
    )
}

//STATE HOISTING TOP BAR
// Make TOP BAR MORE REUSABLE AND STATELESS
//Takes State from the caller
@Composable
fun TopBarStateLess(barTitle: String = stringResource(R.string.app_name)) {
    TopAppBar(
        title = { Text(text = barTitle, fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.purple_200),
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@ExperimentalMaterialApi
@Composable
fun BottomSheetSample() {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,

        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xAA3fa7cc))
            ) {
                Text(
                    text = "Hello from bottom sheet",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
        sheetPeekHeight = 40.dp
    ) {
        MainscreenView(scope, bottomSheetScaffoldState)
    }

}

@ExperimentalMaterialApi
@Composable
fun MainscreenView(scope: CoroutineScope, bottomSheetScaffoldState: BottomSheetScaffoldState) {
    Box(
        Modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .padding(20.dp)
                .align(alignment = Alignment.TopCenter),
            onClick = {
                scope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }
        ) {
            Text(
                text = "Click to show Bottom Sheet"
            )
        }
    }
}
@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalMaterialApi
@Composable
private fun showBottomSheet(
    scope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    scope.launch {
        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
            bottomSheetScaffoldState.bottomSheetState.expand()
        } else {
            bottomSheetScaffoldState.bottomSheetState.collapse()
        }
    }
}