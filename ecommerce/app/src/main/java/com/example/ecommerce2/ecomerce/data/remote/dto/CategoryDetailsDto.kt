package com.example.ecommerce2.ecomerce.data.remote.dto


import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails

data class CategoryDetailsDto (

    val id: Int,

    val items: List<ItemDto>?,

    val logo: String? = "",

    val name: String? = ""
){

    fun toCategoryDetails ():CategoryDetails{
        return CategoryDetails(
            id= id ,
            items=items?.map { it.toItem() } ,
            logo= logo ,
            name = name
        )
    }


}
