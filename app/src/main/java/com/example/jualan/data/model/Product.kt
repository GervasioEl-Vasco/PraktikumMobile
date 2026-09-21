package com.example.jualan.data.model

data class Product(
    val id: Int,
    val name: String,
    val price: String,
    val description: String,
    val categoryId: Int,
    val image: String = "dummy_product"
)
