package com.example.ecommerce2.ecomerce.data.remote.dto

import com.example.ecommerce2.ecomerce.domain.model.Item


data class ItemDto(

    val categoryId: Int,

    val id: Int,

    val logo: String? = null,

    val name: String? = null,

    val price: Double? = null,

    val salePrice: Double? = null
){
    fun toItem (): Item {
        return Item(
            categoryId=categoryId ,
            id= id ,
            logo= logo ,
            name = name,
            price=price,
            salePrice = salePrice
        )
    }
}
