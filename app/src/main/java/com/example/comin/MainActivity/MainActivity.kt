package com.example.comin.MainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.comin.Adapter.ProductPageAdapter
import com.example.comin.Fragment.HomeFragment
import com.example.comin.Fragment.MypageFragment
import com.example.comin.Fragment.ShoppingCartFragment
import com.example.comin.Fragment.WishlistFragment
import com.example.comin.Item.ShoppingCart
import com.example.comin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    companion object {
        var shoppingCart = ArrayList<ShoppingCart>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnv_main)
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener)


        if(savedInstanceState == null)
        {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_main, fragment).commit()
        }

    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.bnv_main_home -> {
                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main, fragment, fragment.javaClass.simpleName).commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.bnv_main_favorite -> {
                val fragment = WishlistFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main, fragment, fragment.javaClass.simpleName).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.bnv_main_cart -> {
                val fragment = ShoppingCartFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main, fragment, fragment.javaClass.simpleName).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.bnv_main_mypage -> {
                val fragment = MypageFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_main, fragment, fragment.javaClass.simpleName).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
