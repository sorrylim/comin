package com.example.comin.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Adapter.ShoppingCartAdapter
import com.example.comin.MainActivity.MainActivity
import com.example.comin.R

class ShoppingCartFragment : Fragment() {

    companion object {
        var price : Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_shopping_cart, container, false)

        price = 0

        var cartRV : RecyclerView = rootView.findViewById(R.id.rv_shoppingcart)
        cartRV.setHasFixedSize(true)
        cartRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        cartRV.adapter = ShoppingCartAdapter(activity!!, MainActivity.shoppingCart)

        var textPrice : TextView = rootView.findViewById(R.id.text_price)

        for(i in 0..MainActivity.shoppingCart.size-1) {
            price += MainActivity.shoppingCart.get(i).productCount * MainActivity.shoppingCart.get(i).productPrice
        }
        textPrice!!.text = price.toString() + "원"

        return rootView
    }
}