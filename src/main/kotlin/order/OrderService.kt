package order

import bank.Bank
import bank.CreditCardBankService
import bank.KakaoBankService
import bank.NaverBankService
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


}