package order

import bank.Bank
import cart.Cart
import data.Food

class OrderService : Order {
    //주문 내역 출력 함수
    override fun printCartList(foodList: List<Food>) {
        println("[ Orders ]")
        for (food in foodList) {
            println("${food.index}. ${food.name}   | ${food.index} | ${food.price}")

        }
    }

    // 주문 총액 출력 함수
    override fun printOrderToTalPrice(cart: Cart) {
        val total = cart.getTotalPrice()
        println("[ Total ]")
        println("W ${total}")
    }

    //금액별로 포인트를 출력해주는 함수.
    override fun printPointResult(bank: Bank) {
        TODO()
    }

}
