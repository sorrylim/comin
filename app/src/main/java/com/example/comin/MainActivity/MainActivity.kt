package com.example.comin.MainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.comin.Adapter.ProductPageAdapter
import com.example.comin.Fragment.HomeFragment
import com.example.comin.R
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState == null)
        {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_main, fragment).commit()
        }

    }
}
