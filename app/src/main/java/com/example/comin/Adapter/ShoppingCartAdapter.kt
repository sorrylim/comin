package com.example.comin.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Fragment.ShoppingCartFragment
import com.example.comin.Item.Product
import com.example.comin.Item.ShoppingCart
import com.example.comin.MainActivity.ProductActivity
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_product.view.*
import kotlinx.android.synthetic.main.item_cartproduct.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_product.view.image_product
import kotlinx.android.synthetic.main.item_product.view.text_producttitle

class ShoppingCartAdapter(val context: Context, val productList:ArrayList<ShoppingCart>) : RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cartproduct, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoppingCartAdapter.ViewHolder, position: Int) {
        holder.itemView.text_producttitle.text = productList.get(position).productTitle
        holder.itemView.text_cartproductprice.text = productList.get(position).productPrice.toString() + "원"
        holder.itemView.text_cartproductcount.text = productList.get(position).productCount.toString()
        holder.itemView.image_product.setImageResource(productList.get(position).productImageView)

        //ShoppingCartFragment.price += productList.get(position).productPrice * productList.get(position).productCount

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindItems(data: String) {

        }
    }


}