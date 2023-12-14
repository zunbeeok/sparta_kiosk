package bank

import common.Time
import java.time.LocalDateTime

interface Bank {
    val bankName : String
    //클래스 생성시 점검시간 셋팅 예정.
    val firstInspectionTime: LocalDateTime;

    val lastInspectionTime: LocalDateTime;
    //포인트 퍼센트
    val pointPercent:Int;

    //은행 점검시간을 조회하는 함수.
    fun getInspectionTime():String{
        return "${bankName} 은행 점검 시간은 ${firstInspectionTime.hour}시 ${firstInspectionTime.minute}분 ~ ${lastInspectionTime.hour}시 ${lastInspectionTime.minute}분이므로 결제할 수 없습니다.";
    };

    fun checkInspectionTime(): Boolean {
        val first :Int = Time.compareTime(firstInspectionTime);
        val last :Int = Time.compareTime(lastInspectionTime);
        if((first == 2 || first ==1 )&& (last == 0 || last ==1)) return false;
        return true;
    }
    //은행별 포인트를 리턴하는 타입.
    fun getPointPercent(): Int {
        return pointPercent;
    }

    //결제가 가능한지 확인하는 함수.
    fun checkPayment(balance:Int ,price:Int):Boolean{
        if(balance - price>0) return true;
        return false;
    };

    fun pay(name: String, price: Int): String {
        val dateTime = Time.formatTimeToString(Time.getNowTime());
        return "[${bankName}] 결제를 완료했습니다. (${dateTime})";
    }
}