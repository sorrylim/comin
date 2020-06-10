package com.example.comin.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.comin.Class.UserInfo
import com.example.comin.IntroActivity.LoginActivity
import com.example.comin.MainActivity.PaymentHistoryActivity
import com.example.comin.R

class MypageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_mypage, container, false)

        val nicknameText : TextView = rootView.findViewById(R.id.text_profilenickname)
        val paymentHistoryText: TextView = rootView.findViewById(R.id.text_payment)
        val logoutText : TextView = rootView.findViewById(R.id.text_logout)

        nicknameText.text = UserInfo.NICKNAME
        paymentHistoryText.setOnClickListener {
            var intent = Intent(activity!!, PaymentHistoryActivity::class.java)
            startActivity(intent)
        }

        logoutText.setOnClickListener {
            var pref=activity!!.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
            var editor=pref.edit()

            editor.clear()
            editor.commit()

            var intent= Intent(activity!!, LoginActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }

}