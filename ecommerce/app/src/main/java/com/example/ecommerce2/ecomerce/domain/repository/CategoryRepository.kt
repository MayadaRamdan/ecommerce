package com.example.ecommerce2.ecomerce.domain.repository


import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.domain.model.Category
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import kotlinx.coroutines.flow.Flow


interface CategoryRepository{

    suspend fun getCategoriesFromApi(): Flow<ResourceState<List<Category>>>


    suspend fun getCategoryDetailsFromApi(categoryId: Int): Flow<ResourceState<CategoryDetails>>

}


