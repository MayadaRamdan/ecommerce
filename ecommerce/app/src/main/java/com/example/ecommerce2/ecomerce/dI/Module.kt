package com.example.ecommerce2.ecomerce.dI

import android.content.Context
import androidx.room.Room
import com.example.ecommerce2.ecomerce.data.local.AppDao
import com.example.ecommerce2.ecomerce.data.local.AppDatabase
import com.example.ecommerce2.ecomerce.data.local.Converter
import com.example.ecommerce2.ecomerce.data.remote.EcomerceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//to provide an object from retrofit when dagger want it
@Module
@InstallIn(SingletonComponent::class)
class Module {

    companion object {

        var categoryApiService: EcomerceApi? = null

        @Provides
        @Singleton
        fun ProvideCategoryApiService(): EcomerceApi {
            val BaseUrl: String = "http://192.168.1.2:8050/store/api/"

            if (categoryApiService == null) {
                categoryApiService = Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(EcomerceApi::class.java)
            }
            return categoryApiService!!
        }


//=====================================================================================================

        @Provides
        fun provideAppDatabase( @ApplicationContext context: Context): AppDatabase {

            return Room.databaseBuilder(context , AppDatabase::class.java , "ecommerce_db")
                .addTypeConverter(Converter())
                .build()
        }

        @Provides
        fun provideAppDao( appDatabase :AppDatabase): AppDao {

            return appDatabase.dao()
        }
    }
}