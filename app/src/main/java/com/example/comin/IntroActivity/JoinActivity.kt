package com.example.comin.IntroActivity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.comin.Class.UserInfo
import com.example.comin.MainActivity.MainActivity
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {
    var idCheck = 0
    var pwCheck = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        edit_joinid.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                idCheck = 0
                text_joinidcheck.text = ""
            }
        })

        edit_joinpasswordcheck.setOnFocusChangeListener { view, b ->
            if(b==false)
            {
                if(edit_joinpassword.text.toString().equals(edit_joinpasswordcheck.text.toString()))
                {
                    text_passwordcheck.text = "비밀번호가 일치합니다."
                    text_passwordcheck.setTextColor(Color.parseColor("#008000"))
                    pwCheck = 1
                }
                else{
                    text_passwordcheck.text = "비밀번호가 일치하지 않습니다."
                    text_passwordcheck.setTextColor(Color.parseColor("#FF0000"))
                    pwCheck = 0
                }
            }
        }

        btn_joinidcheck.setOnClickListener {
            VolleyService.idCheckReq(edit_joinid.text.toString(), this, {success->
                if(success == 0) {
                    text_joinidcheck.text = "중복된 아이디 입니다."
                    text_joinidcheck.setTextColor(Color.parseColor("#FF0000"))
                    idCheck = 0
                }
                else if(success == 1) {
                    text_joinidcheck.text = "사용가능한 아이디 입니다."
                    text_joinidcheck.setTextColor(Color.parseColor("#008000"))
                    idCheck = 1
                }
            })
        }

        btn_joincomplete.setOnClickListener{
            if(idCheck == 0) {
                Toast.makeText(this, "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else if(pwCheck == 0) {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else if(edit_joinnickname.text.toString() == "") {
                Toast.makeText(this, "닉네임을 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                VolleyService.insertUserReq(edit_joinid.text.toString(), edit_joinpassword.text.toString(), edit_joinnickname.text.toString(), this, {success->
                    if(success== "success") {
                        var intent = Intent(this, MainActivity::class.java)
                        UserInfo.ID = edit_joinid.text.toString()
                        UserInfo.PW = edit_joinpassword.text.toString()
                        UserInfo.NICKNAME = edit_joinnickname.text.toString()

                        var pref=this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
                        var editor=pref.edit()
                        editor.putString("ID",UserInfo.ID)
                            .putString("PW",UserInfo.PW)
                            .putString("NICKNAME",UserInfo.NICKNAME)
                            .apply()
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "통신오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

    }
}