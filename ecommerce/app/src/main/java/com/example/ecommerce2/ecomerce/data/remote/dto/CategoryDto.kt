package com.example.ecommerce2.ecomerce.data.remote.dto

import com.example.ecommerce2.ecomerce.data.local.entity.CategoryEntity
import com.example.ecommerce2.ecomerce.domain.model.Category


data class CategoryDto(

    val id: Int ,

    val logo: String = "",

    val name: String = ""
){

    fun toCategory (): Category {
        return Category(
            id= id ,
            logo= logo ,
            name = name
        )
    }

    fun toCategoryEntity (): CategoryEntity {
        return CategoryEntity(
            id= id ,
            logo= logo ,
            name = name
        )
    }
}
