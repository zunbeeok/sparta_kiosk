package order

import bank.Bank

class OrderService :Order{

    override fun purchase(bank: Bank) {
        println(bank.pay());
    }
}