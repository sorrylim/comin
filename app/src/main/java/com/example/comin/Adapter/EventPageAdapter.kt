package com.example.comin.Adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.comin.Fragment.PremiumFragment
import com.example.comin.Fragment.SideMenuFragment
import com.example.comin.Fragment.SquareFragment
import com.example.comin.Fragment.TreasureFragment
import com.example.comin.R

class EventPageAdapter(var context: Context, var imageList:ArrayList<Int>) : PagerAdapter() {

    private var layoutInflater: LayoutInflater?=null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view===`object`
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.item_headerimage, null)
        var image=view.findViewById<ImageView>(R.id.image_header)

        image.setImageResource(imageList.get(position))
        val vp = container as ViewPager
        vp.addView(view , position)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }
}