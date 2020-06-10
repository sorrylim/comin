package com.example.comin.Fragment

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Adapter.ProductAdapter
import com.example.comin.Class.UserInfo
import com.example.comin.Item.Product
import com.example.comin.Item.Wishlist
import com.example.comin.Object.VolleyService
import com.example.comin.R
import org.json.JSONObject

class WishlistFragment : Fragment() {

    var wishlistArrayList = ArrayList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_wishlist, container, false)
        var wishlistRV : RecyclerView = rootView.findViewById(R.id.rv_wishlist)

        VolleyService.getWishlistReq(UserInfo.ID, activity!!, {success->
            wishlistArrayList.clear()
            var array = success
            for(i in 0..array!!.length()-1) {
                var json = array[i] as JSONObject
                if(json.getString("product_category") == "프리미엄도시락") {
                    for(i in 0..PremiumFragment.productList.size-1) {
                        if(json.getString("product_title") == PremiumFragment.productList.get(i).title) {
                            wishlistArrayList.add(Product(PremiumFragment.productList.get(i).imageView,
                                PremiumFragment.productList.get(i).title,
                                PremiumFragment.productList.get(i).count,
                                PremiumFragment.productList.get(i).information,
                                PremiumFragment.productList.get(i).price,
                                PremiumFragment.productList.get(i).category))
                        }
                    }
                }
                else if(json.getString("product_category") == "보물도시락") {
                    for(i in 0..TreasureFragment.productList.size-1) {
                        if(json.getString("product_title") == TreasureFragment.productList.get(i).title) {
                            wishlistArrayList.add(Product(TreasureFragment.productList.get(i).imageView,
                                TreasureFragment.productList.get(i).title,
                                TreasureFragment.productList.get(i).count,
                                TreasureFragment.productList.get(i).information,
                                TreasureFragment.productList.get(i).price,
                                TreasureFragment.productList.get(i).category))
                        }
                    }
                }
                else if(json.getString("product_category") == "사각도시락") {
                    for(i in 0..SquareFragment.productList.size-1) {
                        if(json.getString("product_title") == SquareFragment.productList.get(i).title) {
                            wishlistArrayList.add(Product(SquareFragment.productList.get(i).imageView,
                                SquareFragment.productList.get(i).title,
                                SquareFragment.productList.get(i).count,
                                SquareFragment.productList.get(i).information,
                                SquareFragment.productList.get(i).price,
                                SquareFragment.productList.get(i).category))
                        }
                    }
                }
                else if(json.getString("product_category") == "사이드메뉴") {
                    for(i in 0..SideMenuFragment.productList.size-1) {
                        if(json.getString("product_title") == SideMenuFragment.productList.get(i).title) {
                            wishlistArrayList.add(Product(SideMenuFragment.productList.get(i).imageView,
                                SideMenuFragment.productList.get(i).title,
                                SideMenuFragment.productList.get(i).count,
                                SideMenuFragment.productList.get(i).information,
                                SideMenuFragment.productList.get(i).price,
                                SideMenuFragment.productList.get(i).category))
                        }
                    }
                }
            }

            wishlistRV.setHasFixedSize(true)
            wishlistRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
            wishlistRV.adapter = ProductAdapter(activity!!, wishlistArrayList)
        })

        return rootView
    }

}