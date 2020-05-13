package com.cnm.shw.shoppingmall

enum class ProductEnum(val img: String, val body: String, val price: String, val rating: Float) {
    REF(
        "https://www.costco.co.kr/medias/sys_master/images/h0c/h6f/13979561033758.jpg",
        "삼성 양문형 냉장고 최고급형입니다.\n구입하시면 후회없어요.", "2,500,000", 4.0f
    ),
    MONITOR(
        "https://img.kr.news.samsung.com/kr/wp-content/uploads/2018/07/6L6A8503.jpg",
        "LG 65인치 LED TV입니다.\n구입하시면 후회없어요.", "1,500,000", 5f
    ),
    WASHER(
        "https://www.costco.co.kr/medias/sys_master/images/he4/h69/13047692066846.jpg",
        "대우 통돌이 세탁기입니다.\n구입하시면 후회없어요.", "1,000,000", 4.5f
    ),
    AIRCON(
        "https://dimg.donga.com/wps/NEWS/IMAGE/2019/07/22/96637081.1.jpg",
        "LG 에어컨 입니다.\n구입하시면 후회없어요.", "800,000", 1.5f
    ),
    CLEANER(
        "https://m.acessaks.co.kr/web/product/big/201801/267_shop1_799683.jpg",
        "최신형 무선 청소기 입니다.\n구입하시면 후회없어요.", "500,000", 2f
    );
}