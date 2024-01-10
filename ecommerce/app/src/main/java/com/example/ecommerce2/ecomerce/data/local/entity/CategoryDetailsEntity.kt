package com.example.ecommerce2.ecomerce.data.local.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import com.example.ecommerce2.ecomerce.domain.model.Item


@Entity
data class CategoryDetailsEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val items: List<Item>?,

    val logo: String? = "",

    val name: String? = ""
){

    fun toCategoryDetails ():CategoryDetails{
        return CategoryDetails(
            id= id ,
            items=items,
            logo= logo ,
            name = name
        )
    }


}
