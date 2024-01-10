package com.example.ecommerce2.ecomerce.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ecommerce2.ecomerce.domain.model.CategoryDetails
import com.example.ecommerce2.ecomerce.domain.model.Item
import kotlinx.coroutines.ExperimentalCoroutinesApi

@SuppressLint(
    "UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition",
    "RememberReturnType"
)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoroutinesApi::class)
@Composable
fun ItemsScreen(
    onClickIcon: () -> Unit,
    category: CategoryDetails,
) {
    Scaffold(
        topBar = { itemTopBar(onClickIcon) },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            categoryItemsGrid(category = category)
        }
    }
}


@Composable
fun categoryItemsGrid(category: CategoryDetails) {

    LazyVerticalGrid(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        columns = GridCells.Fixed(2)
    ) {

        items(category.items?.count() ?: 0) {
            category.items?.getOrNull(it)?.let { item ->
                ItemsCard(item = item)
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsCard(item: Item) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .height(275.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = {
        }
    ) {

        AsyncImage(
            modifier = Modifier.height(200.dp),
            model = item.logo, contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(5.dp))

        Column (modifier =Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            item.name?.let { Text(text = it, fontSize = 15.sp) }

            Spacer(modifier = Modifier.height(5.dp))


            Text(text = "Price : "+item.price.toString(), fontSize = 15.sp)

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "salePrice : "+item.salePrice.toString(), fontSize = 15.sp)
        }

    }

}