package com.example.ecommerce2.ecomerce.domain.model



data class CategoryDetails (

    val id: Int,

    val items: List<Item>?,

    val logo: String? = "",

    val name: String? = ""
)
