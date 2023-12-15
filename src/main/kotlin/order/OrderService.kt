package order

import bank.Bank
import bank.CreditCardBankService
import bank.KakaoBankService
import bank.NaverBankService
import cart.Cart
import data.Food
import enum.BankList
import payment.Payment

class OrderService(payment: Payment) :Order{
    private val payment:Payment;

    init {
        this.payment =payment;
    }

    override fun purchase(bankName:BankList):Unit{
        when(bankName){
            BankList.네이버페이 -> payment.payment(NaverBankService());
            BankList.신용카드 -> payment.payment(CreditCardBankService());
            BankList.카카오페이 -> payment.payment(KakaoBankService());
        }
    }

    override fun printCartList(foodList: List<Food>) {
        println("[ Orders ]")
        for (food in foodList) {
            println("${food.index}. ${food.name}   | ${food.price} | ${food.comment}")

        }
    }


    // 주문 총액 출력 함수
    override fun printOrderToTalPrice(cart: Cart){
        val total = cart.getTotalPrice()
        println("[ Total ]")
        println("W ${total}이 결제 됩니다.")
    }

    //금액별로 포인트를 출력해주는 함수.
    override fun printPointResult(bank: Bank):Unit {
        bank.pointPercent;
    }



}