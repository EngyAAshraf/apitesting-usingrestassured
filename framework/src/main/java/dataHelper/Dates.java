package dataHelper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class Dates
{
    public static long startOfDayInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MIN), ZoneId.systemDefault()).toInstant().
                toEpochMilli();
    }

    public static long endOfDayInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MAX), ZoneId.systemDefault()).toInstant().
                toEpochMilli();
    }

    public static long firstDayOfMonthInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MIN).with(TemporalAdjusters.firstDayOfMonth()),
                ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long lastDayOfMonthInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MAX).with(TemporalAdjusters.lastDayOfMonth()),
                ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    public static long truthDateInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MIN), ZoneId.systemDefault()).plusHours(2).toInstant
                ().toEpochMilli();
    }

    public static long lastSecondOfDayInMilliSeconds()
    {
        return ZonedDateTime.of(LocalDateTime.now().with(LocalTime.MIN), ZoneId.systemDefault()).plusDays(1).
                minusNanos(1).toInstant().toEpochMilli();
    }
}
