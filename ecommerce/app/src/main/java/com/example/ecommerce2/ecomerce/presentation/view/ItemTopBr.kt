package com.example.ecommerce2.ecomerce.presentation.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun itemTopBar(onClickIcon :()->Unit){

    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Magenta
        ),
        title = {
                Text(text = "Item")
        },
        navigationIcon = {
            IconButton(onClick =  onClickIcon ) {

                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")

            }
        }

        )

}


