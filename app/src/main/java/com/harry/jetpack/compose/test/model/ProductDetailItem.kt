package com.harry.jetpack.compose.test.model

data class ProductDetailItem(
    val price: Int,
    val name: String,
    val description: String,
    val netContent: String,
    val ingredient: String,
    val images: List<String>,
    val amountLimit: Int = 0
)
