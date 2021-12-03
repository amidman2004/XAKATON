package com.example.testvoronkov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.testvoronkov.ui.theme.TestVoronkovTheme
import com.example.testvoronkov.ui.theme.gol0
import com.example.testvoronkov.ui.theme.gol1

data class icons(var id:String,var title:String,var paint : Int)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestVoronkovTheme {
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
    val color = remember {
        mutableStateOf(Color.White)
    }
    Scaffold(bottomBar = {


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
    Text(text = "HOME")
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

