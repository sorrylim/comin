package com.example.comin.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Adapter.PaymentHistoryAdapter
import com.example.comin.Class.UserInfo
import com.example.comin.Item.Payment
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_payment_history.*
import kotlinx.android.synthetic.main.activity_product_list.*
import org.json.JSONObject

class PaymentHistoryActivity : AppCompatActivity() {
    companion object {
        var HANDLER: Handler? = null
    }
    var paymentHistoryArrayList = ArrayList<Payment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_history)

        setSupportActionBar(toolbar_paymenthistory)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("결제내역")

        VolleyService.getPaymentReq(UserInfo.ID, this, { success->
            paymentHistoryArrayList.clear()
            var array = success
            for(i in 0..array!!.length()-1) {
                var json = array[i] as JSONObject
                paymentHistoryArrayList.add(Payment(json.getInt("payment_id"),
                    json.getString("product_title"),
                    json.getInt("product_count"),
                json.getInt("payment_amount"),
                json.getString("payment_date"),
                json.getInt("payment_review")))
            }
            rv_paymenthitory.setHasFixedSize(true)
            rv_paymenthitory.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rv_paymenthitory.adapter = PaymentHistoryAdapter(this, paymentHistoryArrayList)
        })

        HANDLER = object : Handler() {
            override fun handleMessage(msg: Message?) {
                when (msg!!.what) {
                    0 -> {
                        refresh()
                    }
                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed()
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun refresh() {
        VolleyService.getPaymentReq(UserInfo.ID, this, { success->
            paymentHistoryArrayList.clear()
            var array = success
            for(i in 0..array!!.length()-1) {
                var json = array[i] as JSONObject
                paymentHistoryArrayList.add(Payment(json.getInt("payment_id"),
                    json.getString("product_title"),
                    json.getInt("product_count"),
                    json.getInt("payment_amount"),
                    json.getString("payment_date"),
                    json.getInt("payment_review")))
            }
            rv_paymenthitory.setHasFixedSize(true)
            rv_paymenthitory.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rv_paymenthitory.adapter = PaymentHistoryAdapter(this, paymentHistoryArrayList)
        })
        super.onResume()
    }
}