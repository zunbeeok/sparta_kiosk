package bank

import java.time.LocalDateTime

interface bank {
    val bankName : String
    //클래스 생성시 점검시간 셋팅 예정.
    val inspectionTime: LocalDateTime;

    //포인트 퍼센트
    val pointPersent:Int;

    //은행 점검시간을 조회하는 함수.
    fun getInspectionTime():LocalDateTime;

    //은행 점검시간인지 아닌지 조회하는 함수.
    fun checkInspectionTime(nowTime:LocalDateTime):Boolean;

    //결제가 가능한지 확인하는 함수.
    fun checkPayment(balance:Int ,price:Int):Boolean;

    //결제를 진행시킨다. 금액을 차감시킴.
    fun pay(name: String,price: Int):Int

    fun getPointPersent():Int;

}