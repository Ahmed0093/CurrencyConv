package com.example.currencyconverter.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.currencyconverter.R
import com.example.currencyconverter.data.MovieModel

class ComposeActivitySample2 : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen()
        }
    }


    @ExperimentalMaterialApi
    @Composable
    fun DetailScreen() {
        val navController = rememberNavController()
        BookDetailsScreen(
            movieModel = MovieModel("Micheal", 5f, "David"),
            navController = navController
        )

    }

    @ExperimentalMaterialApi
    @Preview
    @Composable
    fun Preview() {
        DetailScreen()
    }
    //DETAIL SCREEN


    @ExperimentalMaterialApi
    @Composable
    fun BookDetailsScreen(movieModel: MovieModel, navController: NavController) {
       //Surface is it can only hold one child at a time, but it provides
        //many styling options for the content of its children, such as the elevation, border and
        //much more.[Material Design]
         Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                BookPicture(navController)
                BookHeading(movieModel.name, movieModel.author, movieModel.price)
            }
        }
    }

    @Composable
    fun BookPicture(navController: NavController) {
        val activity = (LocalContext.current as? Activity)
        //Box :children of the Box layout will be stacked over each other.
        // align modifier [Modifier.align(Alignment.TopStart)
        // to specify where the composable should be drawn.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color.Red
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(R.drawable.ic_baseline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .clickable {
                        activity?.finish()
                    })
            Text(
                text = "Detail Screen",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.TopCenter)
            )

        }
    }

    @Composable
    fun BookHeading(name: String, author: String, price: Float) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 30.dp, end = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = author,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
            )

            Text(
                text = "$${price}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Column(modifier = Modifier.weight(1f)) {

            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFD7B73)
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Add to Library",
                    style = TextStyle(
                        color = Color.White
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}