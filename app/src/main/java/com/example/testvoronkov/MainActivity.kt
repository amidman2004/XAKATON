package com.example.testvoronkov

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
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

            val currentStyle = remember { mutableStateOf(JetHabbitStyle.textPrimary)}
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
    val context = LocalContext.current

    Scaffold(
        topBar = {
                 TopAppBar(backgroundColor = biruzoviy, content = {
                     IconButton(onClick = { Toast.makeText(context, "${current.value}", Toast.LENGTH_SHORT).show()}, modifier = Modifier
                         .size(40.dp)
                         .background(Color.White, shape = CircleShape)
                         .padding(start = 50.dp)) {

                     val painter = remember {
                         mutableStateOf(R.drawable.image)
                     }
                     Image(painter = painterResource(id = painter.value), contentDescription = null)
                 }})


        },
        bottomBar = {


        BottomNavigation(backgroundColor = gol0, contentColor = Color.White){

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
            "profile" -> Account("FIO")
        }
    }
}

@Composable
fun Prreview2() {
    val context = LocalContext.current
    BottomBar(navController = NavHostController(context))
}

@Composable
fun Home() {
    Text(text = "HOME")
}

@Composable
fun Test() {
    Text(text = "TEST")
}
@Composable
fun Account(FIO:String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.size(30.dp))
            Image(painter = painterResource(id = R.drawable.image), contentDescription = null,
                Modifier
                    .background(
                        Color.White, shape = CircleShape
                    )
                    .align(CenterHorizontally)
                    .size(250.dp))
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = FIO,modifier = Modifier.align(CenterHorizontally))

        }
    }
    Button(onClick = { /*TODO*/ }) {
        
    }
}
@Preview
@Composable
fun rrr() {
    Account(FIO = "FIO")
}

