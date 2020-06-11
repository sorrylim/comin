package com.example.comin.Item

import android.provider.ContactsContract

data class Review(
    var reviewId : Int,
    var productTitle : String,
    var reviewContent : String,
    var reviewDate : String,
    var userNickname : String
)