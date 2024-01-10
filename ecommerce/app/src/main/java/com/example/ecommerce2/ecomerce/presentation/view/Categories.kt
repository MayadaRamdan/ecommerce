

package com.example.ecommerce2.ecomerce.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import coil.compose.AsyncImage
import com.example.ecommerce2.Destination
import com.example.ecommerce2.ecomerce.domain.model.Category


@Composable()
fun nav(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Destination.Categories.route) {
        category(onCategoryClick = { categoryId -> navController.navigateTOItem(categoryId) })

        items(onArrowClicked = { navController.navigateTOCategories() })
    }

}

@Composable
fun categoryGrid(list: List<Category>, onCategoryClick: (categoryId: Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Fixed(1)
        ) {

            items(list.count()) {
                categoryCard(category = list[it], onCategoryClick)

            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun categoryCard(
    category: Category,
    onCategoryClick: (categoryId: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .height(250.dp),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            onCategoryClick(category.id)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.height(200.dp)) {
                AsyncImage(
                    model = category.logo,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = category.name, fontSize = 30.sp)
        }
    }

}