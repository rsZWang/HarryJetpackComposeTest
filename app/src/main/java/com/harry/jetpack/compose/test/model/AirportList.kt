package com.harry.jetpack.compose.test.model

data class AirportList(
    val airports: List<AirportItem>
)

data class AirportItem(
    val code: String,
    val name: String
)