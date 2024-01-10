package com.example.ecommerce2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



sealed class ResourceState<T>(val data: T?=null , val mes :String?=null) {


    class Loading <T>(data : T? =null):ResourceState<T>(data)

    class Success<T>(data:T):ResourceState<T>(data)

    class Error<T>( error:String , data:T?=null):ResourceState<T>(data , error)

}


@Composable
fun Loader(){

    Column (modifier = Modifier
        .fillMaxSize().background(Color.White)
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp),
            color = Color.Black
        )
    }
}

@Composable
fun Error11( error :String ){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = error , fontSize = 50.sp)
    }

}
