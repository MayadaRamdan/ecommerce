package com.example.ecommerce2.ecomerce.data.local


import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.ecommerce2.ecomerce.domain.model.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Provides

@ProvidedTypeConverter
class Converter {

    @TypeConverter
    fun fromItemToString(items: List<Item>):String{
        return Gson().toJson(items) ?:"[]"
    }

    @TypeConverter
    fun fromStringToItem(userString: String):List<Item>{
        return Gson().fromJson<List<Item>>(userString , object :TypeToken<List<Item>>(){}.type) ?: emptyList()
    }


}