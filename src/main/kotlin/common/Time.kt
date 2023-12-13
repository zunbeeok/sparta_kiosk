

package common

import java.time.LocalDateTime
import java.util.Date

// Time은 하나만 생성되고 싶다.
// 공통 기능이니까 컴파일 이후 실행될 때 하나의 인스턴스만 생성이 되게 하려고한다. (static이 뭔지 공부하기)
object Time {
    val nowTime:LocalDateTime

    init {
        //프로그램 실행 시 최초로 실행된다.
        nowTime = LocalDateTime.now();
    }

    // 시간을 비교해주는
    fun compareTime(comTime:LocalDateTime):Boolean{
        // comTime 과 nowTime을 비교해서
        return true;
    }
}