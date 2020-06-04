package com.example.comin.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comin.Adapter.ProductAdapter
import com.example.comin.Item.Product
import com.example.comin.R

class PremiumFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_premium, container, false)
        val premiumRV : RecyclerView = rootView.findViewById(R.id.rv_premium)

        var category = "프리미엄도시락"

        val productList: ArrayList<Product> = arrayListOf(
            Product(R.drawable.premium_1,"매화(치킨, 연어구이)",1,"[베스트 & 스테디셀러 SINCE 2007] 12가지 다양한 반찬으로 구성된 프리미엄 도시락입니다. 푸짐한 반찬과 함께 촉촉하고 부드러운 연어구이와 치킨이 구성되어 있어 부족하지 않고 든든하게 드실 수 있는 도시락 입니다. 생수와 조미 김이 함께 제공 됩니다.","10,000원", category),
            Product(R.drawable.premium_2,"매화(순살 고등어데리야끼)",1,"[베스트 & 스테디셀러 SINCE 2007] 12가지 다양한 반찬으로 구성된 프리미엄 도시락입니다. 푸짐한 반찬과 함께 짭쪼름한 맛이 일품인 고등어 데리야끼 2조각이 구성되어 있어 부족하지 않고 든든하게 드실 수 있는 도시락 입니다. 생수와 조미 김이 함께 제공 됩니다.","10,000원", category),
            Product(R.drawable.premium_3,"진달래",1,"한솥 도시락 Top 5 메뉴 중 하나. 떡 햄버그, 돈까스, 새우튀김, 치킨 가라아게, 제육볶음이 모두 들어 있어 푸짐합니다. 생수와 조미 김이 함께 제공 됩니다.","7,000원", category),
            Product(R.drawable.premium_4,"개나리(순살 고등어 간장구이)",1,"[베스트 & 스테디셀러 SINCE 2008] 고등어데리야끼, 소 불고기, 새우튀김, 치킨 등 누구나 좋아하는 메뉴로 구성된 도시락입니다.","8,000원",category)
        )

        premiumRV.setHasFixedSize(true)
        premiumRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        premiumRV.adapter = ProductAdapter(activity!!, productList)


        return rootView
    }
}