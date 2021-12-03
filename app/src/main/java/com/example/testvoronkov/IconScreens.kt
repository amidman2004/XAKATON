package com.example.testvoronkov

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.core.content.ContextCompat
import com.example.testvoronkov.ui.theme.gol1


sealed class IconScreens(val id: String, val label:String, val icon: Int, var color: Color) {

    //Bottom Nav
    object Home : IconScreens("home", "Home",R.drawable.ic_baseline_home_24, gol1)
    object Test : IconScreens("test", "Test",R.drawable.ic_baseline_notes_24,Color.Gray)
    object CheckList : IconScreens("check", "CheckTest", R.drawable.ic_baseline_checklist_rtl_24,
        Color.Gray)
    object Account : IconScreens("profile", "Profile", R.drawable.ic_baseline_account_box_24, Color.Gray)


}
val list = listOf(
    IconScreens.Home,
    IconScreens.Test,
    IconScreens.CheckList,
    IconScreens.Account
)