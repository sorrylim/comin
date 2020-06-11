package com.example.comin.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.comin.Adapter.ReviewAdapter
import com.example.comin.Item.Review
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_all_review.*
import kotlinx.android.synthetic.main.activity_product.*
import org.json.JSONObject

class AllReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_review)

        setSupportActionBar(toolbar_allreview)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("리뷰")

        var reviewList=ArrayList<Review>()

        VolleyService.getReviewReq(intent.getStringExtra("product_title"),this,{success ->
            var array=success
            for(i in 0..array.length()-1){
                var json=array[i] as JSONObject

                reviewList.add(
                    Review(
                    json.getInt("review_id"),
                    json.getString("product_title"),
                    json.getString("review_content"),
                    json.getString("review_date"),
                    json.getString("user_nickname")
                )
                )
            }
            rv_productreview.adapter= ReviewAdapter(this,reviewList,3)
        })

        rv_allreview
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