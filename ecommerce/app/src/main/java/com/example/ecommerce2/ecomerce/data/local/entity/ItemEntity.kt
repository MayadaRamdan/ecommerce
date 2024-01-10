package com.example.ecommerce2.ecomerce.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecommerce2.ecomerce.domain.model.Item
import org.jetbrains.annotations.NotNull


@Entity
data class ItemEntity(

    @NotNull
    val categoryId: Int,

    @NotNull
    @PrimaryKey
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
