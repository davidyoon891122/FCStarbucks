package com.example.fcstarbucks

import android.view.MenuItem

data class Menu(
    val coffee: List<com.example.fcstarbucks.MenuItem>,
    val food: List<com.example.fcstarbucks.MenuItem>
) {
}

data class MenuItem(
    val name: String,
    val image: String
) {

}