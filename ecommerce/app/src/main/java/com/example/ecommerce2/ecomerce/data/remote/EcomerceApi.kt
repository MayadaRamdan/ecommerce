package com.example.ecommerce2.ecomerce.data.remote

import com.example.ecommerce2.ecomerce.data.remote.dto.CategoryDetailsDto
import com.example.ecommerce2.ecomerce.data.remote.dto.CategoryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EcomerceApi {

    @GET("categories")
    suspend fun getCategories(): List<CategoryDto>?

    @GET("categories/{category_id}")
    suspend fun getCategoryDetails(@Path("category_id") categoryId: Int?): CategoryDetailsDto
}