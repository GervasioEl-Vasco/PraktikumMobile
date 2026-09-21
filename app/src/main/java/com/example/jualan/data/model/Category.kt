package com.example.jualan.data.model

data class Category(
    val id: Int,
    val name: String,
    val description: String? = null,
    val productsCount: Int? = null
)
