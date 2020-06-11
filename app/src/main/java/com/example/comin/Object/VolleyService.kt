package com.example.comin.Object

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Method

object VolleyService {
    val ip = "http://52.78.27.41:1901"

    fun loginReq(userId: String, userPw:String, context: Context, success: (JSONObject) -> Unit) {
        val url = "${ip}/user/login"

        val json = JSONObject()
        json.put("user_id", userId)

        var result = JSONObject()

        var request = object : JsonObjectRequest(Method.POST
            , url
            , json
            , Response.Listener {
                result.put("user", it)
                if (userPw != it.getString("user_password"))
                    result.put("code", 2)
                else if (userPw == it.getString("user_password"))
                    result.put("code", 3)
                success(result)
            }
            , Response.ErrorListener {
                Log.d("test",it.toString())
                if (it is com.android.volley.TimeoutError) {
                    Log.d("test", "TimeoutError")
                    result.put("code", 0)
                } else if (it is com.android.volley.ParseError) {
                    Log.d("test", "ParserError")
                    result.put("code", 1)
                }
                success(result)
            }
        ) {
        }
        //요청을 보내는 부분
        Volley.newRequestQueue(context).add(request)
    }

    fun idCheckReq(userId: String, context: Context, success: (Int) -> Unit) {
        val url = "${ip}/user/check"

        val json = JSONObject()
        json.put("user_id", userId)

        var request = object : JsonObjectRequest(Method.POST
            , url
            , json
            , Response.Listener {
                success(0)
            }
            , Response.ErrorListener {
                if (it is com.android.volley.ParseError) {
                    success(1)
                }
            }
        ) {
            override fun getBodyContentType(): String {
                return "application/json"
            }
        }

        Volley.newRequestQueue(context).add(request)
    }

    fun insertUserReq(userId:String, userPw: String, userNickname: String, context: Context, success:(String?)->Unit) {
        var url = "${ip}/user/insert"

        var json = JSONObject()
        json.put("user_id", userId)
        json.put("user_pw", userPw)
        json.put("user_nickname", userNickname)

        var request = object : JsonObjectRequest(
            Method.POST,
            url,
            json,
            Response.Listener {
                success(it.getString("result"))
            },
            Response.ErrorListener {
                Log.d("test",it.toString())
            }) {}
        Volley.newRequestQueue(context).add(request)
    }


    fun checkWishlistReq(userId:String, productTitle:String, context: Context, success: (JSONObject?)->Unit) {
        var url = "${ip}/wishlist/check"

        var json = JSONObject()
        json.put("user_id", userId)
        json.put("product_title", productTitle)

        var request = object : JsonObjectRequest(
            Method.POST,
            url,
            json,
            Response.Listener {
                success(it)
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun insertWishlistReq(userId:String, productTitle:String, productCategory:String, context: Context, success: (String?)->Unit) {
        var url = "${ip}/wishlist/insert"

        var json = JSONObject()
        json.put("user_id", userId)
        json.put("product_title", productTitle)
        json.put("product_category", productCategory)

        Log.d("test","asd")
        var request = object : JsonObjectRequest(Method.POST,
            url,
            json,
            Response.Listener {
                Log.d("test",it.toString())
                success(it.getString("result"))
            },
            Response.ErrorListener {
                Log.d("test",it.toString())
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun deleteWishlistReq(userId:String, productTitle:String, context: Context, success: (String?)->Unit) {
        var url = "${ip}/wishlist/delete"

        var json = JSONObject()
        json.put("user_id", userId)
        json.put("product_title", productTitle)


        var request = object : JsonObjectRequest(Method.POST,
            url,
            json,
            Response.Listener {
                success(it.getString("result"))
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun getWishlistReq(userId:String,context: Context, success: (JSONArray?)->Unit) {
        var url = "${ip}/wishlist/get"

        var json = JSONObject()
        json.put("user_id", userId)

        var array = JSONArray()
        array.put(json)

        var request = object : JsonArrayRequest(Method.POST,
            url,
            array,
            Response.Listener {
                success(it)
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun paymentReq(
        id: String,
        orderName: String,
        count: Int,
        price: Int,
        paymentDate: String?,
        context: Context
    ) {
        var url="${ip}/payment"

        var json=JSONObject()
        json.put("user_id",id)
            .put("order_name",orderName)
            .put("count",count)
            .put("price",price)
            .put("payment_date",paymentDate)

        var request=object : JsonObjectRequest(
            Method.POST,
            url,
            json,
            Response.Listener {

            },
            Response.ErrorListener {

            }
        ){}

        Volley.newRequestQueue(context).add(request)
    }

    fun getPopularProduct(context: Context, success: (JSONArray) -> Unit) {
        var url="${ip}/payment/popular"

        var array=JSONArray()

        var request=object : JsonArrayRequest(
            Method.POST,
            url,
            array,
            Response.Listener {
                success(it)
            },
            Response.ErrorListener {
                Log.d("test","${it}")
            }
        ){}

        Volley.newRequestQueue(context).add(request)
    }

    fun getPaymentReq(userId:String,context: Context, success: (JSONArray?)->Unit) {
        var url = "${ip}/payment/get"

        var json = JSONObject()
        json.put("user_id", userId)

        var array = JSONArray()
        array.put(json)

        var request = object : JsonArrayRequest(Method.POST,
            url,
            array,
            Response.Listener {
                success(it)
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun insertReviewReq(productTitle: String, userNickname:String, reviewContent:String, reviewDate:String, paymentId: Int, context: Context, success: (String?)->Unit) {
        var url = "${ip}/payment/review"

        var json = JSONObject()
        json.put("product_title", productTitle)
        json.put("user_nickname", userNickname)
        json.put("review_content", reviewContent)
        json.put("payment_id", paymentId)
        json.put("review_date", reviewDate)


        var request = object : JsonObjectRequest(Method.POST,
            url,
            json,
            Response.Listener {
                success(it.getString("result"))
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }

    fun getReviewCountReq(productTitle:String, context: Context, success: (JSONObject?)->Unit) {
        var url = "${ip}/payment/review/count"

        var json = JSONObject()
        json.put("product_title", productTitle)

        var request = object : JsonObjectRequest(
            Method.POST,
            url,
            json,
            Response.Listener {
                Log.d("test",it.toString())
                success(it)
            },
            Response.ErrorListener {
            }) {
        }
        Volley.newRequestQueue(context).add(request)
    }
}