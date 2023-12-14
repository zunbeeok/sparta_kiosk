package order

import data.Food


//김밥, 분식, 식사, 음료
 interface Order {
    // 주문 내역을 아래형태로 출력해준다.
    // [ Orders ]
    // 1. ShackBurger   |  1 개  | W 6.9
    // 2. ChickenBurger |  2 개  | W 13.0   //치킨버거 하나당 가격은 6500원, 2개이므로 13.0을 출력.
    fun printCartList(foodList:List<Food>):Unit;

   //주문 금액의 총 가격을 아래 형태로 return해준다.
   //   [ Total ]
   //   W 6.9
    fun printOrderToTalPrice(foodList:List<Food>):Unit;

   //금액별로 포인트를 출력해주는 함수.
   fun printPointResult():Unit;
}