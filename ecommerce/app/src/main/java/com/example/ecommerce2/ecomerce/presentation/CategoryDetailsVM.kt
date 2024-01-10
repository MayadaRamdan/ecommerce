package com.example.ecommerce2.ecomerce.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.data.repository.CategoryRepositoryImpl
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class CategoryDetailsVM @Inject constructor(
    private val repo: CategoryRepositoryImpl
) : ViewModel() {


    private val _categoryDetails : MutableStateFlow<ResourceState<CategoryDetails>>
            = MutableStateFlow(ResourceState.Loading())

    val categoryDetails :StateFlow<ResourceState<CategoryDetails>> =_categoryDetails


     fun getCategoryDetails(categoryId: Int) {
        viewModelScope.launch (Dispatchers.IO){
            delay(1000)
            repo.getCategoryDetailsFromApi(categoryId).collect {response ->
                _categoryDetails.value=response

            }

        }
    }


    // search for how to create viewstate inside the viewmodel (error, loading, empty and data)
    // stable types and immutable types in jetpack compose
}