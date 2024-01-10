package com.example.ecommerce2

sealed class Destination(val route :String){
    object Categories : Destination("categories}")
    object Items :Destination("item/{categoryId}"){
        fun createRoute(categoryId :Int)= "item/$categoryId"
    }
}
