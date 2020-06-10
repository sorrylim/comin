package com.example.comin.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.comin.Class.UserInfo
import com.example.comin.Item.ShoppingCart
import com.example.comin.Object.VolleyService
import com.example.comin.R
import com.like.LikeButton
import com.like.OnLikeListener
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var intent = intent

        var productTitle = intent.getStringExtra("productTitle")
        var productCategory = intent.getStringExtra("productCategory")
        var productInformation = intent.getStringExtra("productInformation")
        var productImageView = intent.getIntExtra("productImageView", 0)
        var productPrice = intent.getIntExtra("productPrice", 0)


        var count = 1

        text_productprice.text = productPrice.toString() + "원"
        text_registercontent.text = productInformation
        text_productcategory.text = productCategory
        text_registertitle.text = productTitle
        product_image.setImageResource(productImageView)
        text_count.text = count.toString()

        btn_backpress.bringToFront()

        btn_plus.setOnClickListener {
            count++
            text_count.text = count.toString()
        }

        btn_minus.setOnClickListener {
            if(count == 1) {
            }
            else {
                count--;
                text_count.text = count.toString()
            }
        }

        btn_backpress.setOnClickListener{
            finish()
        }

        VolleyService.checkWishlistReq(UserInfo.ID, productTitle, this, { success->
            if(success!!.getInt("count") == 1) {
                btn_favorite.setLiked(true)
            }
            else {
                btn_favorite.setLiked(false)
            }
        })

        btn_favorite.setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton) {
                VolleyService.insertWishlistReq(UserInfo.ID, productTitle, this@ProductActivity, { success->
                    if(success == "success")
                    {
                        likeButton.setLikeDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.heart_on, null))
                        Toast.makeText(this@ProductActivity, "위시리스트에 등록되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this@ProductActivity, "통신오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            override fun unLiked(likeButton: LikeButton) {
                VolleyService.deleteWishlistReq(UserInfo.ID,productTitle, this@ProductActivity, {success->
                    if(success == "success")
                    {
                        likeButton.setLikeDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.heart_off, null))
                        Toast.makeText(this@ProductActivity, "위시리스트에서 제거되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this@ProductActivity, "통신오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        })


        btn_addcart.setOnClickListener {
            MainActivity.shoppingCart.add(ShoppingCart(productTitle, productImageView, productPrice, Integer.parseInt(text_count.text.toString())))
            finish()
        }

    }


}