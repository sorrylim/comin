package com.example.comin.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.comin.Adapter.EventPageAdapter
import com.example.comin.MainActivity.ProductActivity
import com.example.comin.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        var imageList : ArrayList<Int> = arrayListOf(R.drawable.event1, R.drawable.event2, R.drawable.event3, R.drawable.event4)

        var viewPagerHome : ViewPager = rootView.findViewById(R.id.viewpager_home)
        var premiumBtn : ConstraintLayout = rootView.findViewById(R.id.layout_premium)

        viewPagerHome.adapter = EventPageAdapter(activity!!, imageList)

        premiumBtn.setOnClickListener{
            var intent = Intent(activity!!, ProductActivity::class.java)
            intent.putExtra("productType", "프리미엄도시락")
            startActivity(intent)
        }

        return rootView
    }
}