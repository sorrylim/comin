package com.example.comin.Item

import android.graphics.drawable.Drawable

data class Product(
    val imageView: Int,
    val title : String,
    val count : Int,
    val information: String,
    val price : Int,
    val category : String
)