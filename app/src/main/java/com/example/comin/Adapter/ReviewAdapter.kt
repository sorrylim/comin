package com.example.comin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Item.Review
import com.example.comin.R
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewAdapter(val context: Context, val reviewList:ArrayList<Review>, val reviewCount : Int) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return reviewCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cartproduct, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReviewAdapter.ViewHolder, position: Int) {
        holder.itemView.text_nickname.text = reviewList.get(position).userNickname
        holder.itemView.text_date.text = reviewList.get(position).reviewDate
        holder.itemView.text_content.text = reviewList.get(position).reviewContent
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindItems(data: String) {

        }
    }
}