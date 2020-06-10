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

class TreasureFragment : Fragment() {
    companion object{
        var category:String = "보물도시락"

        var productList: ArrayList<Product> = arrayListOf(
            Product(R.drawable.list3_1,"메가불닭치킨 고로케",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트",8200,category),
            Product(R.drawable.list3_2,"메가불닭참치 고로케",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트",8200,category),
            Product(R.drawable.list3_3,"메가불닭치킨 케이준",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트",7700,category),
            Product(R.drawable.list3_4,"메가불닭참치 케이준",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트",7700,category),
            Product(R.drawable.list3_5,"메가불닭치킨마요",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보",6400,category),
            Product(R.drawable.list3_6,"메가불닭참치마요",1,"한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보",6400,category),
            Product(R.drawable.list3_7,"피자불고기마요",1,"한솥 베스트셀러인 마요가 소불고기피자로 변신! 부드러운 3종 믹스치즈, 소불고기, 피자소스의 조화",4700,category),
            Product(R.drawable.list3_8,"피자치킨마요",1,"한솥 베스트셀러인 치킨마요가 피자로 변신! 부드러운 3종믹스 치즈, 치킨, 피자소스의 조화",4500,category),
            Product(R.drawable.list3_9,"갈비치킨마요",1,"10여가지 국산 과일과 채소를 넣어 만든 특제 '한솥갈비소스'로 감칠맛이 가득한 정통갈비구이 맛을 구현했습니다.",3200,category)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_treasure, container, false)
        val treasureRV : RecyclerView = rootView.findViewById(R.id.rv_treasure)





        treasureRV.setHasFixedSize(true)
        treasureRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        treasureRV.adapter = ProductAdapter(activity!!, productList)

        return rootView
    }
}