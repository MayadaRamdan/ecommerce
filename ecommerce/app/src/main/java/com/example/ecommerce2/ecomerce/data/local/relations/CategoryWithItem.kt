package com.example.ecommerce2.ecomerce.data.local.relations


import androidx.room.Embedded
import androidx.room.Relation
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryDetailsEntity
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryEntity
import com.example.ecommerce2.ecomerce.data.local.entity.ItemEntity
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails

data class CategoryWithItem(
    @Embedded
    val categoryEntity: CategoryEntity,

    @Relation(
        parentColumn = "id" ,
        entityColumn = "categoryId"
    )
    val items : List<ItemEntity>
){

    fun toCategoryDetails (): CategoryDetails{
        return CategoryDetails(
            id=categoryEntity.id,
            name = categoryEntity.name ,
            logo = categoryEntity.logo ,
            items = items.map { it.toItem() }

        )
    }
}
