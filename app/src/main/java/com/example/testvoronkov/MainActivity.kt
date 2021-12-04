package com.example.testvoronkov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.indication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testvoronkov.ui.theme.*

data class icons(var id:String,var title:String,var paint : Int)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val darkVakue = isSystemInDarkTheme()

            val currentStyle = remember { mutableStateOf(JetHabbitStyle.TextPrimary)}
            val isDarkMode = remember { mutableStateOf(darkVakue)}

            MainThem(
                style = currentStyle.value,
                darkThem = isDarkMode.value
            ) {
                BottomBar(navController = NavHostController(applicationContext))
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController,items :List<IconScreens> = list) {
    val current = remember {
        mutableStateOf("home")
    }

    Scaffold(bottomBar = {


        BottomNavigation(backgroundColor = JetHabbitTheme.colors.primaryBackground, contentColor = Color.White){

            items.forEach{ item->

                BottomNavigationItem(
                    label = {
                        Text(text = item.label, color = item.color)
                    },
                    selected = item.id == current.value,
                    icon = {
                        Icon(painter = painterResource(id = item.icon), contentDescription = item.label, tint = item.color)
                    },
                    onClick = {
                        current.value = item.id
                        IconScreens.Home.color =  Color.Gray
                        IconScreens.Test.color =  Color.Gray
                        IconScreens.CheckList.color =  Color.Gray
                        IconScreens.Account.color =  Color.Gray
                        item.color = gol1

                    }
                ) 
            }
        }
    }) {
        when(current.value){
            "home" -> Home()
            "test" -> Test()
            "check" -> TestCheck()
            "profile" -> Account()
        }
    }
}


@Composable
fun Home() {

    Column(
        Modifier
            .fillMaxSize()
            .background(JetHabbitTheme.colors.primaryBackground)) {
        LazyColumn(
            Modifier
                .scrollable(rememberLazyListState(), Orientation.Vertical)
                .fillMaxWidth()) {
            item {
                HomeLazy("Название","2")
            }
        }
    }
}


@Composable
fun HomeLazy(name:String,places:String) {
    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = JetHabbitTheme.colors.secondaryBackground,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {

            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)) {
                Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.End,modifier = Modifier.fillMaxWidth()) {
                    Text(text = name, color = JetHabbitTheme.colors.primaryText, modifier = Modifier.padding(end = 5.dp))
                }
                Text(text = name, color = JetHabbitTheme.colors.primaryText, modifier = Modifier.padding(end = 5.dp))

            }
        }
    }
}

@Composable
fun Test() {
    Text(text = "TEST")
}
@Composable
fun TestCheck() {
    Text(text = "TESTCHECK")
}
@Composable
fun Account() {
    Text(text = "ACCOUNT")
}

@Composable
fun Prreview2() {
    val context = LocalContext.current
    BottomBar(navController = NavHostController(context))

    val darkVakue = isSystemInDarkTheme()

    val currentStyle = remember { mutableStateOf(JetHabbitStyle.TextPrimary)}
    val isDarkMode = remember { mutableStateOf(darkVakue)}

    MainThem(
        style = currentStyle.value,
        darkThem = isDarkMode.value
    ) {
        BottomBar(navController = NavHostController(context))
    }
}

