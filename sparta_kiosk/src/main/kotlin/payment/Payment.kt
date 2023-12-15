package payment
import java.time.LocalDateTime

//카카오페이, 네이버페이등 선택해서 다른게 출력 할 수 있게끔
//신용카드, 현금, 카카오페이, 네이버페이 (println 시에 다르게 출력할 수 있게끔)
interface Payment {

    //결제하는 함수, 결제시에는 현재 시간을 출력해준다.
    fun payment(money:Int):Int;


    //은행 리스트를 출력해주는 함수.
    fun printBankList():Unit

}
