package com.beniregev;

import com.beniregev.enums.UserType;
import com.beniregev.model.Schedule;
import com.beniregev.model.User;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class CreateUserDemo {
    public static void main(String[] args) {
        final ZoneId zoneAmericaNewYork = ZoneId.of("America/New_York");
        final ZonedDateTime americaNewYorkCurrentDateTime = ZonedDateTime.now(zoneAmericaNewYork);

        final ZonedDateTime americaNewYorkNineOclock = ZonedDateTime.of ( americaNewYorkCurrentDateTime.toLocalDate() , LocalTime.of ( 9 , 00 ) , zoneAmericaNewYork );
        final ZonedDateTime americaNewYorkTenOclock = ZonedDateTime.of ( americaNewYorkCurrentDateTime.toLocalDate() , LocalTime.of ( 10 , 00 ) , zoneAmericaNewYork );
        //  Initially
        Date scheduledStartTime = Date.from(americaNewYorkNineOclock.toLocalDateTime().atZone(zoneAmericaNewYork).toInstant());

        Schedule schedule = new Schedule();
        schedule.setAllotedDurationMs(500);
        schedule.setAllotedBufferMs(null);
        schedule.setScheduledStartTime(scheduledStartTime);

        User user = new User(1, "adminuser", UserType.ADMIN, "administrator");
        user.setSchedule(schedule);
    }
}
