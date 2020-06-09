package com.example.comin.Object

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.reflect.Method

object VolleyService {
    val ip = "http://52.78.27.41:3001"

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
            }) {
        }
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

    fun insertWishlistReq(userId:String, productTitle:String, context: Context, success: (String?)->Unit) {
        var url = "${ip}/wishlist/insert"

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
}