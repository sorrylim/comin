package com.example.comin.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.comin.Adapter.ProductPageAdapter
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        var intent = intent

        var productType = intent.getStringExtra("productType")

        setSupportActionBar(toolbar_productlist)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(productType)


        val productPageAdapter = ProductPageAdapter(supportFragmentManager)
        viewpager_product.adapter= productPageAdapter
        tab_product.setupWithViewPager(viewpager_product)

        if(productType == "프리미엄도시락")
            viewpager_product.currentItem = 0
        else if(productType == "사각도시락")
            viewpager_product.currentItem = 1
        else if(productType == "보물도시락")
            viewpager_product.currentItem = 2
        else if(productType == "사이드메뉴")
            viewpager_product.currentItem = 3
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed()
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}