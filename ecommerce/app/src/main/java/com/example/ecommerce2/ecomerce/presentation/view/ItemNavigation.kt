package com.example.ecommerce2.ecomerce.presentation.view

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ecommerce2.Destination
import com.example.ecommerce2.Error11
import com.example.ecommerce2.Loader
import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import com.example.ecommerce2.ecomerce.presentation.CategoryDetailsVM

fun NavController.navigateTOItem(categoryId: Int) {
    navigate(Destination.Items.createRoute(categoryId = categoryId)) {
        popUpTo(Destination.Items.route)
    }
}

fun NavGraphBuilder.items(onArrowClicked: () -> Unit) {
    composable(
        Destination.Items.route,
        arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
    ) {

        val vm = hiltViewModel<CategoryDetailsVM>()
        val id = remember { it.arguments!!.getInt("categoryId") }
        LaunchedEffect(key1 = id) { vm.getCategoryDetails(id) }
        val categoryD = vm.categoryDetails.collectAsState()

        when(categoryD.value){
            is ResourceState.Loading<*> ->{
                Loader()
            }
            is ResourceState.Success<*> ->{

                val response= (categoryD.value as ResourceState.Success<*>).data as CategoryDetails
               ItemsScreen(onClickIcon = onArrowClicked, category = response)
            }
            is ResourceState.Error<*> -> {
                val error = (categoryD.value as ResourceState.Error<*>).mes
                if (error != null) {
                    Error11(error)
                }
            }
        }
    }

}

