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


class SideMenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_side_menu, container, false)
        val sideMenuRV : RecyclerView = rootView.findViewById(R.id.rv_sidemenu)
        var category:String = "사이드메뉴"

        val productList: ArrayList<Product> = arrayListOf(
            Product(R.drawable.second1,"치킨샐러드",1,"노릇하게 구운 순 닭다릿살 슬라이스를 토핑한 한 그릇 샐러드 도시락입니다. 유자드레싱과 사과드레싱 중 하나를 선택할 수 있습니다.",3600,category),
            Product(R.drawable.second2,"계란말이",1,"부드럽고 촉촉한 맛이 특징인 반찬 계란말이 입니다. 도시락과 함께 곁들여드시면 더욱 좋습니다. ",2200,category),
            Product(R.drawable.second3,"해물파전",1,"신선한 부추와 오징어로 감칠맛을 더한 바삭한 해물부추전",2200,category),
            Product(R.drawable.second4,"군만두",1,"바삭한 피의 식감과 담백한 고기속이 어우러져 입안 가득 느껴지는 고기의 풍미와 육즙이 일품인 바삭 군만두",2000,category),
            Product(R.drawable.second5,"핫도그",1,"찹쌀반죽에 앙증맞은 미니 소시지가 들어있어서 겉은 바삭하면서도 속은 쫀득한 품격있는 식감을 제대로 느낄 수 있는 미니 찹쌀핫도그",2500,category),
            Product(R.drawable.second6,"카레",1,"누구도 흉내 낼 수 없는 한결같은 맛을 고수해오며 20년 동안 인기를 이어온 오리지널 한솥 카레입니다.",2400,category),
            Product(R.drawable.second7,"김치찌개",1,"진한 사골육수에 묵은지 김치와 부드러운 돼지 앞다리 살을 넣어 깔끔하고 담백한 찌개입니다.",3900,category),
            Product(R.drawable.second8,"녹두전",1,"집에서 만든 것 처럼 김치, 숙주, 돼지고기 등 속을 푸짐하게 넣어 부쳐낸 녹두전",2700,category),
            Product(R.drawable.second9,"오징어젓갈",1,"쫄깃한식감의 오징어를 매콤 짭짤하게 담은 오징어젓갈",400,category),
            Product(R.drawable.second10,"김치",1,"국내산 배추와 국내산 고춧가루 등 우리 농산물만 오롯이 사용한 국내산 100% 배추김치입니다.",300,category),
            Product(R.drawable.second11,"콜라 및 사이다",1,"시원한 코카콜라와 칠성사이다로 목을 축이세요",1500,category)
        )

        sideMenuRV.setHasFixedSize(true)
        sideMenuRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        sideMenuRV.adapter = ProductAdapter(activity!!, productList)


        return rootView
    }
}