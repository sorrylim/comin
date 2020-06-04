package com.example.comin.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.comin.Fragment.PremiumFragment
import com.example.comin.Fragment.SideMenuFragment
import com.example.comin.Fragment.SquareFragment
import com.example.comin.Fragment.TreasureFragment

class ProductPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) : Fragment {
        return when(position) {
            0 -> {
                PremiumFragment()
            }
            1 -> {
                SquareFragment()
            }
            2 -> {
                TreasureFragment()
            }
            else -> {
                return SideMenuFragment()
            }
        }
    }

    override fun getCount() : Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "프리미엄"
            1 -> "사각"
            2 -> "보물"
            else -> {return "사이드"}
        }
    }




}