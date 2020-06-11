package com.example.comin.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_payment_history.*
import kotlinx.android.synthetic.main.activity_product_list.*

class PaymentHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_history)

        setSupportActionBar(toolbar_paymenthistory)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("결제내역")


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
}