package payment

import bank.Bank

class PaymentService:Payment {
    override fun printBankList() {
        TODO("Not yet implemented")
    }

    override fun payment(bank: Bank): Unit {
        println(bank.pay());
    }

}