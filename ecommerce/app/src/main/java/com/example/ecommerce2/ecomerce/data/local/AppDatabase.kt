package com.example.ecommerce2.ecomerce.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryDetailsEntity
import com.example.ecommerce2.ecomerce.data.local.entity.CategoryEntity
import com.example.ecommerce2.ecomerce.data.local.entity.ItemEntity
import dagger.Provides
import javax.inject.Singleton


@Database(
    entities = [CategoryEntity::class ,CategoryDetailsEntity::class, ItemEntity::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class AppDatabase :RoomDatabase (){

    abstract fun dao() : AppDao


    @Volatile
    private var INSTANCE : AppDatabase?=null

    fun getDBInstance(context: Context): AppDatabase {
        synchronized(this){
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "ecommerce.db",
            ).addTypeConverter(Converter())
                .fallbackToDestructiveMigration()
                .build().also {
                    INSTANCE=it
                }
        }
    }



}