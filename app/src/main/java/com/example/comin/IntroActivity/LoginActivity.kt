package com.example.comin.IntroActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.comin.Class.UserInfo
import com.example.comin.MainActivity.MainActivity
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        text_signup.setOnClickListener{
            var intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            var userId=edit_loginid.text.toString()
            var userPw=edit_loginpw.text.toString()
            VolleyService.loginReq(userId, userPw,this, { success ->
                when(success.getInt("code")){
                    0 -> {
                        Toast.makeText(this,"서버와의 통신에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        Toast.makeText(this,"계정을 확인해주세요.", Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        Toast.makeText(this,"ID / PW를 확인해주세요.", Toast.LENGTH_SHORT).show()
                    }
                    3 -> {
                        var user=success.getJSONObject("user")
                        UserInfo.ID=user.getString("user_id")
                        UserInfo.PW=user.getString("user_password")
                        UserInfo.NICKNAME=user.getString("user_nickname")

                        var pref=this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
                        var editor=pref.edit()
                        editor.putString("ID",UserInfo.ID)
                            .putString("PW",UserInfo.PW)
                            .putString("NICKNAME",UserInfo.NICKNAME)
                            .apply()

                        var intent: Intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }

            })
        }
    }
}