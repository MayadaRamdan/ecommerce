package com.example.ecommerce2.ecomerce.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce2.ResourceState
import com.example.ecommerce2.ecomerce.data.repository.CategoryRepositoryImpl
import com.example.ecommerce2.ecomerce.domain.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class CategoryViewModel @Inject constructor(private val repo: CategoryRepositoryImpl) : ViewModel() {


    private val _categoriesList : MutableStateFlow<ResourceState<List<Category>>>
            = MutableStateFlow(ResourceState.Loading())

    val categoriesList :StateFlow<ResourceState<List<Category>>> =_categoriesList

    init {
        getCategoryList()
    }

    private fun getCategoryList() {
        viewModelScope.launch (Dispatchers.IO){
            delay(1000)
            repo.getCategoriesFromApi().collect {response ->
                _categoriesList.value=response

            }

        }
    }




}

