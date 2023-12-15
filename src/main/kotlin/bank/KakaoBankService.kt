package bank

import common.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class KakaoBankService :Bank{
    override val bankName: String

    override val firstInspectionTime: LocalDateTime

    override val lastInspectionTime: LocalDateTime

    override val pointPercent: Int;

    init {
        this.bankName = "카카오"
        this.firstInspectionTime =LocalDateTime.of(LocalDate.now(),LocalTime.of(23,50));
        this.lastInspectionTime =firstInspectionTime.plusMinutes(15);
        this.pointPercent = 5;
    }

}