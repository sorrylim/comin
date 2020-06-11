package com.example.comin.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.comin.Fragment.PremiumFragment
import com.example.comin.Fragment.SideMenuFragment
import com.example.comin.Fragment.SquareFragment
import com.example.comin.Fragment.TreasureFragment
import com.example.comin.Item.Product
import com.example.comin.MainActivity.ProductActivity
import com.example.comin.R

class EventPageAdapter(var context: Context, var productList:ArrayList<Product>) : PagerAdapter() {

    private var layoutInflater: LayoutInflater?=null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view===`object`
    }

    override fun getCount(): Int {
        return productList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.item_headerimage, null)
        var image=view.findViewById<ImageView>(R.id.image_header)
        var textBest=view.findViewById<TextView>(R.id.text_best)
        var textTitle=view.findViewById<TextView>(R.id.text_title)

        image.setImageResource(productList[position].imageView)
        textBest.text="Best${position+1}"
        textTitle.text="${productList[position].title}"

        view.setOnClickListener {
            var intent = Intent(context, ProductActivity::class.java)
            intent.putExtra("productTitle", productList.get(position).title)
            intent.putExtra("productInformation", productList.get(position).information)
            intent.putExtra("productCategory", productList.get(position).category)
            intent.putExtra("productImageView", productList.get(position).imageView)
            intent.putExtra("productPrice", productList.get(position).price)
            context.startActivity(intent)
        }

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