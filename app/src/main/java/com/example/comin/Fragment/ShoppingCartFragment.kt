package com.example.comin.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Adapter.ShoppingCartAdapter
import com.example.comin.Class.UserInfo
import com.example.comin.MainActivity.MainActivity
import com.example.comin.Object.VolleyService
import com.example.comin.R
import kr.co.bootpay.Bootpay
import kr.co.bootpay.enums.Method
import kr.co.bootpay.enums.PG
import kr.co.bootpay.enums.UX
import kr.co.bootpay.model.BootExtra
import kr.co.bootpay.model.BootUser
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ShoppingCartFragment : Fragment() {

    companion object {
        var price : Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_shopping_cart, container, false)

        price = 0

        var cartRV : RecyclerView = rootView.findViewById(R.id.rv_shoppingcart)
        cartRV.setHasFixedSize(true)
        cartRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        cartRV.adapter = ShoppingCartAdapter(activity!!, MainActivity.shoppingCart)

        var textPrice : TextView = rootView.findViewById(R.id.text_price)

        for(i in 0..MainActivity.shoppingCart.size-1) {
            price += MainActivity.shoppingCart.get(i).productCount * MainActivity.shoppingCart.get(i).productPrice
        }
        textPrice!!.text = "총액 : ${price.toString()}원"
        var btnPurchase=rootView.findViewById<Button>(R.id.btn_purchase)
        btnPurchase.setOnClickListener {
            if(MainActivity.shoppingCart.size!=0){
                var orderName="${MainActivity.shoppingCart[0].productTitle}"
                if(MainActivity.shoppingCart.size>1){
                    orderName+=" 외 ${MainActivity.shoppingCart.size-1}개의 상품"
                }

                var bootUser = BootUser().setPhone("010-4154-5154")
                var bootExtra = BootExtra().setQuotas(IntArray(3){0;2;3});

                var orderId="${orderName}_${ZonedDateTime.now(ZoneId.of("Asia/Seoul"))}"

                var paymentDate=ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                Bootpay.init(activity!!.fragmentManager)
                    .setApplicationId("59a4d326396fa607cbe75de5") // 해당 프로젝트(안드로이드)의 application id 값
                    .setPG(PG.KAKAO) // 결제할 PG 사
                    .setMethod(Method.EASY) // 결제수단
                    .setContext(activity!!)
                    .setBootUser(bootUser)
                    .setBootExtra(bootExtra)
                    .setUX(UX.PG_DIALOG)
                    //.setUserPhone(buyerPhone) // 구매자 전화번호
                    .setName(orderName) // 결제할 상품명
                    .setOrderId(orderId) // 결제 고유번호expire_month
                    .setPrice(price) // 결제할 금액
                    .onConfirm{
                        Bootpay.confirm(it)
                    }
                    .onDone {
                        // 결제완료시 호출, 아이템 지급 등 데이터 동기화 로직을 수행합니다
                        // 주문내역 서버에 입력
                        for(i in 0..MainActivity.shoppingCart.size-1)
                            VolleyService.paymentReq(
                                orderId+i
                                ,UserInfo.ID
                                ,MainActivity.shoppingCart[i].productTitle
                                ,MainActivity.shoppingCart[i].productCount.toString()
                                ,MainActivity.shoppingCart[i].productPrice.toString()
                                ,paymentDate
                                ,activity!!)

                        MainActivity.shoppingCart.clear()
                        cartRV!!.adapter!!.notifyDataSetChanged()
                        textPrice!!.text="총액 : 0원"
                    }
                    .onReady {
                        // 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
                    }
                    .onCancel {
                        // 결제 취소시 호출
                    }
                    .onError {
                        // 에러가 났을때 호출되는 부분
                        Log.d("test",it)
                    }.onClose {
                        //결제창이 닫힐때 실행되는 부분
                    }.request()
            }
        }
        return rootView
    }
}