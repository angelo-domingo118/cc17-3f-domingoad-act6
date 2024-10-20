package com.example.activity6_30daysapp

data class Tip(
    val title: String,
    val description: String,
    val imageResId: Int,
    var completed: Boolean = false
)
