package com.example.ecommerce2.ecomerce.domain.model



data class Item(

    val categoryId: Int,

    val id: Int,

    val logo: String? = null,

    val name: String? = null,

    val price: Double? = null,

    val salePrice: Double? = null
)
