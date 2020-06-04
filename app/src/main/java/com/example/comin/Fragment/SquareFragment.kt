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

class SquareFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_square, container, false)
        val squareRV : RecyclerView = rootView.findViewById(R.id.rv_square)

        var category : String = "사각도시락"

        var productList : ArrayList<Product> = arrayListOf(Product(R.drawable.square1,"메가고기고기",1,"고기고기 도시락의 소불고기와 제육볶음이 2.5배 증량된 메가고기고기에 도전하세요!","7,900원", category),
        Product(R.drawable.square2,"생선까스도련님고기고기",1,"생선까스와 떡햄버그, 치킨으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴","5,500원", category),
        Product(R.drawable.square3,"돈까스도련님고기고기",1,"돈까스와 떡햄버그, 치킨으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴","5,500원", category),
        Product(R.drawable.square4,"탕수육도련님고기고기",1,"돈까스와 바삭한 찹쌀탕수육으로 구성된 도련님 도시락에 제육볶음과 소불고기를 더해 푸짐하고 가성비 좋은 19년 7월 신메뉴","5,600원",category),
        Product(R.drawable.square5,"새치 고기고기",1,"새우튀김, 치킨가라아게, 불고기, 제육볶음으로 구성한 새.치.고기.고기 도시락입니다. 새우튀김은 흰다리새우(중하)가 통으로 들어가 탱글탱글한 식감이 살아있으며 치킨가라아게는 부드러운 순 닭다리살을 간장으로 가미한 후 튀겨내 짭조름한 감칠맛이 좋습니다.","6,000원",category),
        Product(R.drawable.square6,"돈치 고기고기",1,"돈까스, 치킨가라아게, 소불고기, 제육볶음으로 구성한 돈.치.고기.고기 도시락입니다. 고기반찬과 튀김을 함께 즐기고 싶은 분에게 추천합니다. 한솥의 돈까스는 국내산 돼지고기의 등심 부위를 도톰하게 썰어 튀겨 육즙이 풍부합니다.","5,200원",category),
        Product(R.drawable.square7,"고기고기",1,"두 가지 고기반찬을 넣어 푸짐한 도시락입니다. 한솥이 개발한 특제 불고기 소스에 부드러운 호주산 쇠고기를 재워 만든 소불고기, 부드러우면서도 씹는 맛이 살아있는 매콤한 제육볶음을 모두 드실 수 있습니다.","4,000원",category),
        Product(R.drawable.square8,"제육 김치찌개 정식",1,"따끈한 집밥이 연상되는 한상차림의 정식메뉴 제육볶음과 묵은지 김치찌개의 완벽한 조합 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.","8,000원",category),
        Product(R.drawable.square9,"고등어 불고기 정식",1,"따끈한 집밥이 연상되는 한상차림의 정식메뉴 제육볶음, 소불고기, 순살고등어 간장구이로 담백함과 푸짐함을 동시에 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.","7,000원",category),
        Product(R.drawable.square10,"콤비네이션 정식",1,"따끈한 집밥이 연상되는 한상차림의 정식메뉴 10가지 다양한 반찬으로 구성된 정식도시락입니다. 정식메뉴에는 계란후라이 조미김 미니생수가 함께 제공됩니다.","6,000원",category),
        Product(R.drawable.square11,"숯불직화구이",1,"석쇠에 구워 숯불향이 가득한 직화구이와 다양한 반찬 정식도시락, 라유소스로 매콤한 풍미까지!","6,500원",category),
        Product(R.drawable.square12,"소불고기",1,"담백한 소불고기와 다양한 반찬의 정식 도시락","5,000원",category),
        Product(R.drawable.square13,"메가치킨제육",1,"치킨제육 도시락의 치킨과 제육이 2.5배 증량된 메가치킨제육에 도전하세요!","6,900원",category),
        Product(R.drawable.square14,"생선까스도련님",1,"도련님 도시락의 새로운 시리즈로 생선까스와 타르타르소스를 넣어 구성했습니다.","3,900원",category),
        Product(R.drawable.square15,"칠리 찹쌀탕수육도련님",1,"돈까스와 바삭한 찹쌀탕수육으로 구성된 3번째 도련님 시리즈를 매콤달콤한 칠리소스와 함께 즐겨보세요","4,000원",category),
        Product(R.drawable.square16,"오리지널 찹쌀탕수육",1,"바삭하고 쫀득한 찹쌀탕수육, 새콤달콤한 오리지널 탕수육 소스를 찍먹! 부먹!으로 취향에 따라 즐겨보세요","4,700원",category),
        Product(R.drawable.square17,"동백",1,"[베스트&스테디셀러 SINCE 2008] 연하고 부드러운 햄버그에 쫄깃한 떡을 넣은 떡햄버그와 탱글탱글한 식감이 살아있는 새우튀김, 호주산 소불고기, 한솥만의 명품 치킨, 해물 볼어묵, 각종 밑반찬은 물론 김, 타르타르소스가 들어간 도시락입니다.","5,000원",category),
        Product(R.drawable.square18,"치킨제육",1,"치킨가라아게와 부드러운 제육볶음으로 구성한 도시락입니다. 짭조름한 치킨과 매콤한 제육볶음으로 든든한 한 끼가 됩니다.","4,400원",category),
        Product(R.drawable.square19,"국화",1,"[베스트&스테디셀러 SINCE 1994] 두툼한 국내산 돼지고기 등심 돈까스, 담백한 명태로 만든 생선까스, 부드러우면서도 씹는 맛이 살아있는 제육볶음, 계절별 밑반찬이 모두 담긴 모둠 도시락입니다.","4,200원",category),
        Product(R.drawable.square20,"돈까스도련님",1,"[베스트&스테디셀러 SINCE 1994] 도련님 도시락의 오징어까스 대신 두툼한 돼지고기 등심으로 만든 돈까스를 넣어 구성했습니다. 한솥의 대표 메뉴입니다.","3,900원",category),
        Product(R.drawable.square21,"제육볶음",1,"볶음용으로 가장 맛있는 부위로 만든 제육볶음을 듬뿍 담았습니다. 간이 잘 배고 부드러운 제육볶음과 계절 반찬으로 구성해 누구나 좋아합니다.","3,900원",category),
        Product(R.drawable.square22,"한솥밥",1,"지하 150m 암반수로 씻어낸 무세미로 지은 쌀밥입니다. 한솥은 매 달 온도와 환경을 고려하여 만든 레시피대로 쌀을 불리고 물양을 조절하여 맛있게 지은 따끈한 밥을 제공합니다.","1,000원",category),
        Product(R.drawable.square23,"현미밥",1,"100% 국내산 현미밥입니다. 식이섬유소와 각종 영양소가 풍부하여 건강에 좋으면서도 거친 식감까지 잡아 부드럽습니다.","1,700원",category))


        squareRV.setHasFixedSize(true)
        squareRV.layoutManager = LinearLayoutManager(activity!!, RecyclerView.VERTICAL, false)
        squareRV.adapter = ProductAdapter(activity!!, productList)


        return rootView
    }
}