package com.example.comin.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Item.Product
import com.example.comin.R
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(val context: Context, val productList:ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.itemView.text_producttitle.text = productList.get(position).title
        holder.itemView.text_productreviewcount.text = productList.get(position).count.toString()
        holder.itemView.text_producttype.text = productList.get(position).category
        holder.itemView.image_product.setImageResource(productList.get(position).imageView)



    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindItems(data: String) {

        }
    }


}
