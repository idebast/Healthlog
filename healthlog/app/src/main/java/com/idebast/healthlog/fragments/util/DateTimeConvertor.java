package com.idebast.healthlog.fragments.util;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateTimeConvertor {
    /**
     * convert datetime (wrt unix epoch) into an adjusted timestamp
     * @param ldt datetime timestamp to convert (wrt unix epoch)
     * @param rdt reference timestamp
     * @return number of seconds elapsed between timestamp and new reference timestamp
     */
    public static long dateTimeToNewRef (LocalDateTime ldt, LocalDateTime rdt) {

        //https://stackoverflow.com/questions/40490323/java-subtracting-localdatetime-foo-from-localdatetime-bar/40491166
        Duration duration = Duration.between(rdt, ldt);
        return duration.toMinutes();
   }

    /**
     * convert an adjusted timestamp to a datetime (wrt unix epoch)
     * @param adt adjusted timestamp to convert (wrt unix epoch)
     * @param rdt reference timestamp
     * @return datetime (wrt unix epoch)
     */
    public static LocalDateTime newRefTodateTime (long adt, LocalDateTime rdt) {
        // https://stackoverflow.com/questions/30374796/how-can-i-add-an-int-minutes-to-localdatetime-now
        return rdt.plusMinutes(adt);
    }

}
