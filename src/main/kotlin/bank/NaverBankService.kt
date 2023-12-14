package bank

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class NaverBankService :Bank{
    override val bankName: String

    override val firstInspectionTime: LocalDateTime

    override val lastInspectionTime: LocalDateTime

    override val pointPercent: Int

    init {
        this.bankName = "네이버"
        this.firstInspectionTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,45));
        this.lastInspectionTime =firstInspectionTime.plusMinutes(15);
        this.pointPercent = 10;
    }
}