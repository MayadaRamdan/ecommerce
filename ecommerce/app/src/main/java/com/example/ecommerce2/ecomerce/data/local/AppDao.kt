package com.example.ecommerce2.ecomerce.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryDetailsEntity
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryEntity
import com.example.ecommerce2.ecomerce.data.local.entity.ItemEntity
import com.example.ecommerce2.ecomerce.data.local.relations.CategoryWithItem
import dagger.Provides


@Dao
interface AppDao{


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCategoryList (categories : CategoryEntity)

    @Query("SELECT * FROM CategoryEntity ")
    suspend fun getCategory():List<CategoryEntity>

    //--------------------------------------------------------------------

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCategoryDetails ( categoryDetails: CategoryDetailsEntity)

    // -------------------------------------------------------------------

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertItem (items :ItemEntity)

    @Transaction
    @Query("SELECT * FROM CategoryEntity WHERE id=:id ")
    suspend fun getCategoryWithItems( id :Int): CategoryWithItem

}

