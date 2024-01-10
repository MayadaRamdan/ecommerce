package com.example.ecommerce2.ecomerce.presentation.view

import android.annotation.SuppressLint
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.ecommerce2.Destination
import com.example.ecommerce2.Error11
import com.example.ecommerce2.Loader
import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.domain.model.Category
import com.example.ecommerce2.ecomerce.presentation.CategoryViewModel


fun NavController.navigateTOCategories() {
    navigate(Destination.Categories.route) {
        popUpTo(Destination.Categories.route)

    }
}

@SuppressLint("CoroutineCreationDuringComposition")
fun NavGraphBuilder.category(onCategoryClick: (categoryId: Int) -> Unit) {
    composable(Destination.Categories.route) {

        val categoryViewModel = hiltViewModel<CategoryViewModel>()

        val category=categoryViewModel.categoriesList.collectAsState()

        when(category.value){
            is ResourceState.Loading<*> ->{
                Loader()
            }
            is ResourceState.Success<*> ->{

                val response= (category.value as ResourceState.Success<*>).data as List<Category>
                categoryGrid( response , onCategoryClick =onCategoryClick )
            }
            is ResourceState.Error<*> -> {
                val error = (category.value as ResourceState.Error<*>)
                    Error11(error.toString())

            }
        }

    }
}


