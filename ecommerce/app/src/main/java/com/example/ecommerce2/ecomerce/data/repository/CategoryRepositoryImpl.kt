package com.example.ecommerce2.ecomerce.data.repository


import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.data.local.AppDao
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryDetailsEntity
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryEntity
import com.example.ecommerce2.ecomerce.data.local.entity.ItemEntity
import com.example.ecommerce2.ecomerce.data.remote.EcomerceApi
import com.example.ecommerce2.ecomerce.domain.model.Category
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import com.example.ecommerce2.ecomerce.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApiService: EcomerceApi,
    private val categoryDao: AppDao
) : CategoryRepository {


    override suspend fun getCategoriesFromApi(): Flow<ResourceState<List<Category>>> {

        return flow {

            emit(ResourceState.Loading())

            val localDb = categoryDao.getCategory().map { it.toCategory() }

            emit(ResourceState.Loading(localDb))

            try {

                val response = categoryApiService.getCategories()

                response?.forEach{
                    categoryDao.upsertCategoryList(it.toCategoryEntity())
                }

            } catch (e: Exception) {
                emit(ResourceState.Error(error = " Oops can not call the server", localDb))
            }

            val newCategory = categoryDao.getCategory().map { it.toCategory() }
            emit(ResourceState.Success(newCategory))

        }
    }


    override suspend fun getCategoryDetailsFromApi(categoryId: Int): Flow<ResourceState<CategoryDetails>> {
        return flow {

            emit(ResourceState.Loading())

            val localDb = categoryDao.getCategoryWithItems(categoryId)

            emit(ResourceState.Loading(localDb.toCategoryDetails()))

            try {

                val response = categoryApiService.getCategoryDetails(categoryId) as CategoryDetails

                categoryDao.upsertItem(response.items as ItemEntity)

                categoryDao.upsertCategoryDetails(response as CategoryDetailsEntity)

            } catch (e: Exception) {

                emit(
                    ResourceState.Error(
                        error = " Oops can not call the server",
                        (localDb.toCategoryDetails())
                    )
                )
            }

            val newCategory = categoryDao.getCategoryWithItems(categoryId).toCategoryDetails()
            emit(ResourceState.Success(newCategory))

        }


    }

}


