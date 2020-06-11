package com.example.comin.Adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Class.UserInfo
import com.example.comin.Fragment.ShoppingCartFragment
import com.example.comin.Item.Payment
import com.example.comin.Item.ShoppingCart
import com.example.comin.MainActivity.PaymentHistoryActivity
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kotlinx.android.synthetic.main.item_cartproduct.view.*
import kotlinx.android.synthetic.main.item_paymenthistory.view.*
import kotlinx.android.synthetic.main.item_product.view.*
import kotlinx.android.synthetic.main.item_product.view.image_product
import kotlinx.android.synthetic.main.item_product.view.text_producttitle
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class PaymentHistoryAdapter(val context: Context, val productList:ArrayList<Payment>) : RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHistoryAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_paymenthistory, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PaymentHistoryAdapter.ViewHolder, position: Int) {

        holder.itemView.text_producttitle.text = productList.get(position).title
        holder.itemView.text_paymentdate.text = productList.get(position).date
        holder.itemView.text_productcount.text = "x" + productList.get(position).count.toString()
        holder.itemView.text_productprice.text = (productList.get(position).price * productList.get(position).count).toString() + "원"

        if(productList.get(position).review == 1) {
            holder.itemView.text_insertreview.visibility = View.GONE
        }
        else if(productList.get(position).review == 0) {
            holder.itemView.text_insertreview.setOnClickListener{
                val dialog = Dialog(context, android.R.style.Theme_DeviceDefault_Light_NoActionBar)
                dialog.setContentView(R.layout.dialog_insertreview)
                val dialogContent = dialog.findViewById<EditText>(R.id.edit_insertreview)
                val dialogButton = dialog.findViewById<Button>(R.id.btn_insertreview)

                dialog.getWindow()!!.statusBarColor = Color.TRANSPARENT
                dialog.getWindow()!!.getAttributes().windowAnimations = R.style.AnimationPopupStyle
                dialog.show()

                dialogButton.setOnClickListener{
                    var reviewDate=
                        ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    VolleyService.insertReviewReq(productList.get(position).title, UserInfo.NICKNAME, dialogContent.text.toString(), reviewDate,
                    productList.get(position).id, context, {success->
                            if(success =="success")
                            {
                                Toast.makeText(context, "리뷰작성완료", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                                var msg=PaymentHistoryActivity.HANDLER!!.obtainMessage()
                                msg.what=0
                                PaymentHistoryActivity.HANDLER!!.sendMessage(msg)
                            }
                            else {
                                Toast.makeText(context, "서버와의 통신실패", Toast.LENGTH_SHORT).show()
                            }
                        })

                }
            }
        }

    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun bindItems(data: String) {

        }
    }


}