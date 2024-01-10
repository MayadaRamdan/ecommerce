package com.example.ecommerce2.ecomerce.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ecommerce2.ecomerce.domain.model.Category
import org.jetbrains.annotations.NotNull


@Entity
data class CategoryEntity(

    @NotNull
    @PrimaryKey(autoGenerate = true)
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
}
