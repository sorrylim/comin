package com.example.comin.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.comin.Adapter.EventPageAdapter
import com.example.comin.Item.Product
import com.example.comin.MainActivity.ProductListActivity
import com.example.comin.Object.VolleyService
import com.example.comin.R
import org.json.JSONObject

class HomeFragment : Fragment() {

    var bestList = ArrayList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        var viewPagerHome: ViewPager = rootView.findViewById(R.id.viewpager_home)
        var premiumBtn: ConstraintLayout = rootView.findViewById(R.id.layout_premium)
        var squareBtn: ConstraintLayout = rootView.findViewById(R.id.layout_square)
        var treasureBtn: ConstraintLayout = rootView.findViewById(R.id.layout_treasure)
        var sideMenuBtn: ConstraintLayout = rootView.findViewById(R.id.layout_sidemenu)

        VolleyService.getPopularProduct(activity!!, { success ->
            var array = success

            for (i in 0..array.length()-1) {
                var title = (array[i] as JSONObject).getString("product_title")
                addProductList(title)
            }
            viewPagerHome.adapter = EventPageAdapter(activity!!, bestList)
        })

        premiumBtn.setOnClickListener {
            var intent = Intent(activity!!, ProductListActivity::class.java)
            intent.putExtra("productType", "프리미엄도시락")
            startActivity(intent)
        }

        squareBtn.setOnClickListener {
            var intent = Intent(activity!!, ProductListActivity::class.java)
            intent.putExtra("productType", "사각도시락")
            startActivity(intent)
        }

        treasureBtn.setOnClickListener {
            var intent = Intent(activity!!, ProductListActivity::class.java)
            intent.putExtra("productType", "보물도시락")
            startActivity(intent)
        }

        sideMenuBtn.setOnClickListener {
            var intent = Intent(activity!!, ProductListActivity::class.java)
            intent.putExtra("productType", "사이드메뉴")
            startActivity(intent)
        }

        return rootView
    }

    private fun addProductList(title: String) {
        when (title) {
            //프리미엄 도시락
            "매화(치킨, 연어구이)" -> {
                bestList.add(
                    Product(
                        R.drawable.premium_1,
                        "매화(치킨, 연어구이)",
                        1,
                        "[베스트 & 스테디셀러 SINCE 2007] 12가지 다양한 반찬으로 구성된 프리미엄 도시락입니다. 푸짐한 반찬과 함께 촉촉하고 부드러운 연어구이와 치킨이 구성되어 있어 부족하지 않고 든든하게 드실 수 있는 도시락 입니다. 생수와 조미 김이 함께 제공 됩니다.",
                        10000,
                        PremiumFragment.category
                    )
                )
            }
            "매화(순살 고등어데리야끼)" -> {
                bestList.add(
                    Product(
                        R.drawable.premium_2,
                        "매화(순살 고등어데리야끼)",
                        1,
                        "[베스트 & 스테디셀러 SINCE 2007] 12가지 다양한 반찬으로 구성된 프리미엄 도시락입니다. 푸짐한 반찬과 함께 짭쪼름한 맛이 일품인 고등어 데리야끼 2조각이 구성되어 있어 부족하지 않고 든든하게 드실 수 있는 도시락 입니다. 생수와 조미 김이 함께 제공 됩니다.",
                        10000,
                        PremiumFragment.category
                    )
                )
            }
            "진달래" -> {
                bestList.add(
                    Product(
                        R.drawable.premium_3,
                        "진달래",
                        1,
                        "한솥 도시락 Top 5 메뉴 중 하나. 떡 햄버그, 돈까스, 새우튀김, 치킨 가라아게, 제육볶음이 모두 들어 있어 푸짐합니다. 생수와 조미 김이 함께 제공 됩니다.",
                        7000,
                        PremiumFragment.category
                    )
                )
            }
            "개나리(순살 고등어 간장구이)" -> {
                bestList.add(
                    Product(
                        R.drawable.premium_4,
                        "개나리(순살 고등어 간장구이)",
                        1,
                        "[베스트 & 스테디셀러 SINCE 2008] 고등어데리야끼, 소 불고기, 새우튀김, 치킨 등 누구나 좋아하는 메뉴로 구성된 도시락입니다.",
                        8000,
                        PremiumFragment.category
                    )
                )
            }
            //사각 도시락
            "메가고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square1,
                        "메가고기고기",
                        1,
                        "고기고기 도시락의 소불고기와 제육볶음이 2.5배 증량된 메가고기고기에 도전하세요!",
                        7900,
                        SquareFragment.category
                    )
                )
            }
            "생선까스도련님고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square2,
                        "생선까스도련님고기고기",
                        1,
                        "생선까스와 떡햄버그, 치킨으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴",
                        5500,
                        SquareFragment.category
                    )
                )
            }
            "돈까스도련님고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square3,
                        "돈까스도련님고기고기",
                        1,
                        "돈까스와 떡햄버그, 치킨으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴",
                        5500,
                        SquareFragment.category
                    )
                )
            }
            "탕수육도련님고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square4,
                        "탕수육도련님고기고기",
                        1,
                        "돈까스와 바삭한 찹쌀탕수육으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴",
                        5600,
                        SquareFragment.category
                    )
                )
            }
            "새치 고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square5,
                        "새치 고기고기",
                        1,
                        "새우튀김, 치킨가라아게, 불고기, 제육볶음으로 구성한 새.치.고기.고기 도시락입니다. 새우튀김은 흰다리새우(중하)가 통으로 들어가 탱글탱글한 식감이 살아있으며 치킨가라아게는 부드러운 순 닭다리살을 간장으로 가미한 후 튀겨내 짭조름한 감칠맛이 좋습니다.",
                        6000,
                        SquareFragment.category
                    )
                )
            }
            "돈치 고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square6,
                        "돈치 고기고기",
                        1,
                        "돈까스, 치킨가라아게, 소불고기, 제육볶음으로 구성한 돈.치.고기.고기 도시락입니다. 고기반찬과 튀김을 함께 즐기고 싶은 분에게 추천합니다. 한솥의 돈까스는 국내산 돼지고기의 등심 부위를 도톰하게 썰어 튀겨 육즙이 풍부합니다.",
                        5200,
                        SquareFragment.category
                    )
                )
            }
            "고기고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square7,
                        "고기고기",
                        1,
                        "두 가지 고기반찬을 넣어 푸짐한 도시락입니다. 한솥이 개발한 특제 불고기 소스에 부드러운 호주산 쇠고기를 재워 만든 소불고기, 부드러우면서도 씹는 맛이 살아있는 매콤한 제육볶음을 모두 드실 수 있습니다.",
                        4000,
                        SquareFragment.category
                    )
                )
            }
            "제육 김치찌개 정식" -> {
                bestList.add(
                    Product(
                        R.drawable.square8,
                        "제육 김치찌개 정식",
                        1,
                        "따끈한 집밥이 연상되는 한상차림의 정식메뉴 제육볶음과 묵은지 김치찌개의 완벽한 조합 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.",
                        8000,
                        SquareFragment.category
                    )
                )
            }
            "고등어 불고기 정식" -> {
                bestList.add(
                    Product(
                        R.drawable.square9,
                        "고등어 불고기 정식",
                        1,
                        "따끈한 집밥이 연상되는 한상차림의 정식메뉴 제육볶음, 소불고기, 순살고등어 간장구이로 담백함과 푸짐함을 동시에 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.",
                        7000,
                        SquareFragment.category
                    )
                )
            }
            "콤비네이션 정식" -> {
                bestList.add(
                    Product(
                        R.drawable.square10,
                        "콤비네이션 정식",
                        1,
                        "따끈한 집밥이 연상되는 한상차림의 정식메뉴 10가지 다양한 반찬으로 구성된 정식도시락입니다. 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.",
                        6000,
                        SquareFragment.category
                    )
                )
            }
            "숯불직화구이" -> {
                bestList.add(
                    Product(
                        R.drawable.square11,
                        "숯불직화구이",
                        1,
                        "석쇠에 구워 숯불향이 가득한 직화구이와 다양한 반찬 정식도시락, 라유소스로 매콤한 풍미까지!",
                        6500,
                        SquareFragment.category
                    )
                )
            }
            "소불고기" -> {
                bestList.add(
                    Product(
                        R.drawable.square12,
                        "소불고기",
                        1,
                        "담백한 소불고기와 다양한 반찬의 정식 도시락",
                        5000,
                        SquareFragment.category
                    )
                )
            }
            "메가치킨제육" -> {
                bestList.add(
                    Product(
                        R.drawable.square13,
                        "메가치킨제육",
                        1,
                        "치킨제육 도시락의 치킨과 제육이 2.5배 증량된 메가치킨제육에 도전하세요!",
                        6900,
                        SquareFragment.category
                    )
                )
            }
            "생선까스도련님" -> {
                bestList.add(
                    Product(
                        R.drawable.square14,
                        "생선까스도련님",
                        1,
                        "도련님 도시락의 새로운 시리즈로 생선까스와 타르타르소스를 넣어 구성했습니다.",
                        3900,
                        SquareFragment.category
                    )
                )
            }
            "칠리 찹쌀탕수육도련님" -> {
                bestList.add(
                    Product(
                        R.drawable.square15,
                        "칠리 찹쌀탕수육도련님",
                        1,
                        "돈까스와 바삭한 찹쌀탕수육으로 구성된 3번째 도련님 시리즈를 매콤달콤한 칠리소스와 함께 즐겨보세요",
                        4000,
                        SquareFragment.category
                    )
                )
            }
            "오리지널 찹쌀탕수육" -> {
                bestList.add(
                    Product(
                        R.drawable.square16,
                        "오리지널 찹쌀탕수육",
                        1,
                        "바삭하고 쫀득한 찹쌀탕수육, 새콤달콤한 오리지널 탕수육 소스를 찍먹! 부먹!으로 취향에 따라 즐겨보세요",
                        4700,
                        SquareFragment.category
                    )
                )
            }
            "동백" -> {
                bestList.add(
                    Product(
                        R.drawable.square17,
                        "동백",
                        1,
                        "[베스트&스테디셀러 SINCE 2008] 연하고 부드러운 햄버그에 쫄깃한 떡을 넣은 떡햄버그와 탱글탱글한 식감이 살아있는 새우튀김, 호주산 소불고기, 한솥만의 명품 치킨, 해물 볼어묵, 각종 밑반찬은 물론 김, 타르타르소스가 들어간 도시락입니다.",
                        5000,
                        SquareFragment.category
                    )
                )
            }
            "치킨제육" -> {
                bestList.add(
                    Product(
                        R.drawable.square18,
                        "치킨제육",
                        1,
                        "치킨가라아게와 부드러운 제육볶음으로 구성한 도시락입니다. 짭조름한 치킨과 매콤한 제육볶음으로 든든한 한 끼가 됩니다.",
                        4400,
                        SquareFragment.category
                    )
                )
            }
            "국화" -> {
                bestList.add(
                    Product(
                        R.drawable.square19,
                        "국화",
                        1,
                        "[베스트&스테디셀러 SINCE 1994] 두툼한 국내산 돼지고기 등심 돈까스, 담백한 명태로 만든 생선까스, 부드러우면서도 씹는 맛이 살아있는 제육볶음, 계절별 밑반찬이 모두 담긴 모둠 도시락입니다.",
                        4200,
                        SquareFragment.category
                    )
                )
            }
            "돈까스도련님" -> {
                bestList.add(
                    Product(
                        R.drawable.square20,
                        "돈까스도련님",
                        1,
                        "[베스트&스테디셀러 SINCE 1994] 도련님 도시락의 오징어까스 대신 두툼한 돼지고기 등심으로 만든 돈까스를 넣어 구성했습니다. 한솥의 대표 메뉴입니다.",
                        3900,
                        SquareFragment.category
                    )
                )
            }
            "제육볶음" -> {
                bestList.add(
                    Product(
                        R.drawable.square21,
                        "제육볶음",
                        1,
                        "볶음용으로 가장 맛있는 부위로 만든 제육볶음을 듬뿍 담았습니다. 간이 잘 배고 부드러운 제육볶음과 계절 반찬으로 구성해 누구나 좋아합니다.",
                        3900,
                        SquareFragment.category
                    )
                )
            }
            "한솥밥" -> {
                bestList.add(
                    Product(
                        R.drawable.square22,
                        "한솥밥",
                        1,
                        "지하 150m 암반수로 씻어낸 무세미로 지은 쌀밥입니다. 한솥은 매 달 온도와 환경을 고려하여 만든 레시피대로 쌀을 불리고 물양을 조절하여 맛있게 지은 따끈한 밥을 제공합니다.",
                        1000,
                        SquareFragment.category
                    )
                )
            }
            "현미밥" -> {
                bestList.add(
                    Product(
                        R.drawable.square23,
                        "현미밥",
                        1,
                        "100% 국내산 현미밥입니다. 식이섬유소와 각종 영양소가 풍부하여 건강에 좋으면서도 거친 식감까지 잡아 부드럽습니다.",
                        1700,
                        SquareFragment.category
                    )
                )
            }
            //보물 도시락
            "메가불닭치킨 고로케" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_1,
                        "메가불닭치킨 고로케",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트",
                        8200,
                        TreasureFragment.category
                    )
                )
            }
            "메가불닭참치 고로케" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_2,
                        "메가불닭참치 고로케",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+감자고로케+ 피크닉)세트",
                        8200,
                        TreasureFragment.category
                    )
                )
            }
            "메가불닭치킨 케이준" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_3,
                        "메가불닭치킨 케이준",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트",
                        7700,
                        TreasureFragment.category
                    )
                )
            }
            "메가불닭참치 케이준" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_4,
                        "메가불닭참치 케이준",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보 (+케이준 후라이+ 피크닉)세트",
                        7700,
                        TreasureFragment.category
                    )
                )
            }
            "메가불닭치킨마요" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_5,
                        "메가불닭치킨마요",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보",
                        6400,
                        TreasureFragment.category
                    )
                )
            }
            "메가불닭참치마요" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_6,
                        "메가불닭참치마요",
                        1,
                        "한솥 시그니처 메뉴인 '마요'시리즈와 삼양 불닭소스의 콜라보",
                        6400,
                        TreasureFragment.category
                    )
                )
            }
            "피자불고기마요" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_7,
                        "피자불고기마요",
                        1,
                        "한솥 베스트셀러인 마요가 소불고기피자로 변신! 부드러운 3종 믹스치즈, 소불고기, 피자소스의 조화",
                        4700,
                        TreasureFragment.category
                    )
                )
            }
            "피자치킨마요" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_8,
                        "피자치킨마요",
                        1,
                        "한솥 베스트셀러인 치킨마요가 피자로 변신! 부드러운 3종믹스 치즈, 치킨, 피자소스의 조화",
                        4500,
                        TreasureFragment.category
                    )
                )
            }
            "갈비치킨마요" -> {
                bestList.add(
                    Product(
                        R.drawable.list3_9,
                        "갈비치킨마요",
                        1,
                        "10여가지 국산 과일과 채소를 넣어 만든 특제 '한솥갈비소스'로 감칠맛이 가득한 정통갈비구이 맛을 구현했습니다.",
                        3200,
                        TreasureFragment.category
                    )
                )
            }
            //사이드 메뉴
            "치킨샐러드" -> {
                bestList.add(
                    Product(
                        R.drawable.second1,
                        "치킨샐러드",
                        1,
                        "노릇하게 구운 순 닭다릿살 슬라이스를 토핑한 한 그릇 샐러드 도시락입니다. 유자드레싱과 사과드레싱 중 하나를 선택할 수 있습니다.",
                        3600,
                        SideMenuFragment.category
                    )
                )
            }
            "계란말이" -> {
                bestList.add(
                    Product(
                        R.drawable.second2,
                        "계란말이",
                        1,
                        "부드럽고 촉촉한 맛이 특징인 반찬 계란말이 입니다. 도시락과 함께 곁들여드시면 더욱 좋습니다. ",
                        2200,
                        SideMenuFragment.category
                    )
                )
            }
            "해물파전" -> {
                bestList.add(
                    Product(
                        R.drawable.second3, "해물파전", 1, "신선한 부추와 오징어로 감칠맛을 더한 바삭한 해물부추전", 2200,
                        SideMenuFragment.category
                    )
                )
            }
            "군만두" -> {
                bestList.add(
                    Product(
                        R.drawable.second4,
                        "군만두",
                        1,
                        "바삭한 피의 식감과 담백한 고기속이 어우러져 입안 가득 느껴지는 고기의 풍미와 육즙이 일품인 바삭 군만두",
                        2000,
                        SideMenuFragment.category
                    )
                )
            }
            "핫도그" -> {
                bestList.add(
                    Product(
                        R.drawable.second5,
                        "핫도그",
                        1,
                        "찹쌀반죽에 앙증맞은 미니 소시지가 들어있어서 겉은 바삭하면서도 속은 쫀득한 품격있는 식감을 제대로 느낄 수 있는 미니 찹쌀핫도그",
                        2500,
                        SideMenuFragment.category
                    )
                )
            }
            "카레" -> {
                bestList.add(
                    Product(
                        R.drawable.second6,
                        "카레",
                        1,
                        "누구도 흉내 낼 수 없는 한결같은 맛을 고수해오며 20년 동안 인기를 이어온 오리지널 한솥 카레입니다.",
                        2400,
                        SideMenuFragment.category
                    )
                )
            }
            "김치찌개" -> {
                bestList.add(
                    Product(
                        R.drawable.second7,
                        "김치찌개",
                        1,
                        "진한 사골육수에 묵은지 김치와 부드러운 돼지 앞다리 살을 넣어 깔끔하고 담백한 찌개입니다.",
                        3900,
                        SideMenuFragment.category
                    )
                )
            }
            "녹두전" -> {
                bestList.add(
                    Product(
                        R.drawable.second8,
                        "녹두전",
                        1,
                        "집에서 만든 것 처럼 김치, 숙주, 돼지고기 등 속을 푸짐하게 넣어 부쳐낸 녹두전",
                        2700,
                        SideMenuFragment.category
                    )
                )
            }
            "오징어젓갈" -> {
                bestList.add(
                    Product(
                        R.drawable.second9, "오징어젓갈", 1, "쫄깃한식감의 오징어를 매콤 짭짤하게 담은 오징어젓갈", 400,
                        SideMenuFragment.category
                    )
                )
            }
            "김치" -> {
                bestList.add(
                    Product(
                        R.drawable.second10,
                        "김치",
                        1,
                        "국내산 배추와 국내산 고춧가루 등 우리 농산물만 오롯이 사용한 국내산 100% 배추김치입니다.",
                        300,
                        SideMenuFragment.category
                    )
                )
            }
            "콜라 및 사이다" -> {
                bestList.add(
                    Product(
                        R.drawable.second11, "콜라 및 사이다", 1, "시원한 코카콜라와 칠성사이다로 목을 축이세요", 1500,
                        SideMenuFragment.category
                    )
                )
            }

        }
    }
}