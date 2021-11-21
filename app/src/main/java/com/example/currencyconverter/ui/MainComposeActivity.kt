package com.example.currencyconverter.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.currencyconverter.R
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.currencyconverter.data.MovieModel
import com.example.currencyconverter.databinding.OldLayoutBinding

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainBoardScreen()
        }
    }

    private val onToastButtonClick: (String) -> Unit = { name ->
        val intent = Intent(this, ComposeActivitySample2::class.java)
        startActivity(intent)
    }


    @Composable
    fun SampleUI(name: String) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(4.dp)),

                contentScale = ContentScale.Crop

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "A day in Shark Fin Cove",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "$name, Davenport, California",
                style = typography.body2
            )
            Text(
                "December 2019",
                style = typography.body2
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SampleUiPreview() {
        SampleUI("Test")
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomNavigationBarPreview() {
        BottomNavigationBar(rememberNavController())
    }


    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Music,
            NavigationItem.Movies,
            NavigationItem.Books,
            NavigationItem.Profile
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.cardview_dark_background),
            contentColor = Color.White,
        ) {
            // [currentBackStackEntryAsState] Returns: a mutable state of the current back stack entry
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { startDest ->
                                    popUpTo(startDest) {
                                        saveState = true
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }


    sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
        object Home : NavigationItem("home", R.drawable.ic_baseline_home_24, "Home")
        object Music : NavigationItem("music", R.drawable.ic_baseline_library_books_24, "Music")
        object Movies : NavigationItem("movies", R.drawable.ic_baseline_movie_24, "Movies")
        object Books : NavigationItem("books", R.drawable.ic_baseline_library_books_24, "Books")
        object Profile : NavigationItem("profile", R.drawable.ic_baseline_home_24, "Profile")
    }

    @Composable
    fun HomeScreen() {
        // Row :horizontal version—a LinearLayout
        //Column : Vertical Version of Linear Layout
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.design_default_color_primary))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Home View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
            AndroidViewXMLExample()
        }


    }

    @Preview(showBackground = true)
    @Composable
    fun HomeScreenPreview() {
        HomeScreen()
    }

    @Composable
    fun MusicScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.design_default_color_primary))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Music View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MusicScreenPreview() {
        MusicScreen()
    }

    @Composable
    fun MoviesScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.design_default_color_primary))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Movies View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MoviesScreenPreview() {
        MoviesScreen()
    }

    @Composable
    fun ToastButton(name: String) {
        Button(onClick = { onToastButtonClick(name) }) {
            Text(text = "Show Toast")
        }
    }

    val onButtonClick2: (String) -> Unit = { name ->
        Log.v("click2", "click22")
        Toast.makeText(applicationContext, "Saying Hello to $name", Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun BooksScreen() {
        val context = LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.design_default_color_primary))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Books View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        onToastButtonClick //NOT WORKING !
                    }
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
            ToastButton(name = "name1")

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun BooksScreenPreview() {
        BooksScreen()
    }

    @Composable
    fun ProfileScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.design_default_color_primary))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Profile View",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ProfileScreenPreview() {
        ProfileScreen()
    }


    @Composable
    fun MainBoardScreen() {
        val navController = rememberNavController()
        //Scaffold is a new layout that Jetpack Compose introduced follows the Material Design structure
        Scaffold(
            topBar = { TopBarStateLess() },//TopBar() },
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            NavHostContainer(navController)
        }
        //KOTLIN DSL
//        foo{
//
//        }
//        fooWithLastArgument("myId") {
//
//        }
        fooLambdaWithReceiver("") {
            //Direct access to MovieModel fields
            name = ""
        }
    }

    //KOTLIN DSL
    fun foo(f: () -> Unit) {

    }

    fun fooWithLastArgument(id: String, c: () -> Unit) {

    }
    fun fooLambdaWithReceiver(id: String, c: MovieModel.() -> Unit) {

    }
    @Composable
    fun NavHostContainer(navController: NavHostController) {
        NavHost(navController, startDestination = NavigationItem.Home.route) {
          //composable for each route
            //Replacement of Old XML Navigation..
            composable(route = NavigationItem.Home.route) {
                HomeScreen()
            }
            composable(route = NavigationItem.Music.route) {
                MusicScreen()
            }
            composable(route = NavigationItem.Movies.route) {
                MoviesScreen()
            }
            composable(route = NavigationItem.Books.route) {
                BooksScreen()
            }
            composable(route = NavigationItem.Profile.route) {
                ProfileScreen()
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun TopBarPreview() {
        TopBar()
    }

    @Preview(showBackground = true)
    @Composable
    fun OldXMLPreview() {
        AndroidViewXMLExample()
    }

    @Composable
    fun AndroidViewXMLExample() {
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.teal_200))
                .wrapContentSize(Alignment.Center)
                .height(200.dp)
        ) {
            AndroidViewBinding(factory = OldLayoutBinding::inflate) {
                //this.textVid.text = "OVERRIDE FROM COMPOESE"
//                this.ivBenefit.setImageDrawable(
//                    ResourcesCompat.getDrawable(
//                        resources,
//                        R.drawable.ic_launcher_background, null
//                    )
                // )
            }
        }
    }

    //--PASS ARGUMENTS -Navigation With DATA ..
//    fun gotoBookDetails(bookModel: BookModel, navController: NavController) {
//        navController.currentBackStackEntry?.arguments?.putParcelable("book", bookModel)
//        navController.navigate("book_details")
//    }

    //IN NAV CONTROLLER ALREADy Add ROUTE
    // Book Details
//    composable("book_details") {
//        var bookModel = navController.previousBackStackEntry?.arguments?.getParcelable<BookModel>("book")
//        bookModel?.let {
//            BookDetailsScreen(bookModel = it, navController = navController)
//        }
//    }
}
