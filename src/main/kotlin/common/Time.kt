

package common

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


// Time은 하나만 생성되고 싶다.
// 공통 기능이니까 컴파일 이후 실행될 때 하나의 인스턴스만 생성이 되게 하려고한다. (static이 뭔지 공부하기)
object Time {
    val nowTime:LocalDateTime

    private val dateTimePattern = "yyyy-MM-dd HH:mm:ss";

    init {
        //프로그램 실행 시 최초로 실행된다.
        nowTime = LocalDateTime.now();
    }

    //현재 시간을 조회하는 함수
    fun getNowTime():LocalDateTime{
        return nowTime;
    }

    // input시간과 현재시간을 비교해서 return 해주는 함수 작을 경우 0, 같을 경우 1, 클 경우 2
    fun compareTime(compareTime:LocalDateTime):Int{
        return if( compareTime.isBefore(nowTime)){
             0;
        }else if( compareTime.isEqual(nowTime)){
             1;
        }else{
             2;
        }
    }

    //"yyyy-MM-dd HH:mm:ss"형식으로 반환.
    fun formatTimeToString(input:LocalDateTime):String{
        return SimpleDateFormat(dateTimePattern).format(input);
    }


    fun stringToLocalDateTime(input:String):LocalDateTime{
        return LocalDateTime.parse(input, DateTimeFormatter.ofPattern(dateTimePattern));
    }


}