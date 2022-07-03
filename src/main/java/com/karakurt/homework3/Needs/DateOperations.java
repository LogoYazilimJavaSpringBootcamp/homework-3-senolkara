package com.karakurt.homework3.Needs;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public interface DateOperations {
    static final LocalDate registerDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Month.JUNE,1);
    static final LocalDate startDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Month.MAY,31);
    static final LocalDate endDate = LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Month.JULY,1);
    LocalDate createdDT = null;
    LocalDate getCreatedDT();
    void setCreatedDT(LocalDate createdDT);
}
