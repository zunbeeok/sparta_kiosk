package cart

import food.Food

interface Cart {
    // 주문할 음식 리스트.
    val cartList:List<Food>;

    // 메뉴 결정시 카트에 주문을 추가한다.
    fun addCart(food: Food, count:Int):List<Food>;

    // getCartList에서 반환되는 index로 카트에 요소를 삭제한다.
    fun deleteCart(index: Int):List<Food>;

    // cartList의 배열을 반환한다.
    fun getCartList():List<Food>;

    // cartList의 배열을 출력해준다.
    fun printCartList();


}