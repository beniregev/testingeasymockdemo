package com.beniregev;

import com.beniregev.enums.UserType;
import com.beniregev.model.Schedule;
import com.beniregev.model.User;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.verify;

public class UserTest extends EasyMockSupport {
    private final ZoneId zoneAmericaNewYork = ZoneId.of("America/New_York");
    private ZonedDateTime americaNewYorkNineOclock;
    private ZonedDateTime americaNewYorkTenOclock;

    @Mock
    private Schedule schedule;
    @Mock
    private User user;

    private final List<Object> mocks = new ArrayList<>();

    @Before
    public void setup() {
        user = createMock(User.class);
        schedule = createMock(Schedule.class);

        mocks.add(schedule);
        mocks.add(user);

        mocks.forEach(EasyMock::reset);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreateUser() {
        //  current date-time in ZoneID
        final ZonedDateTime americaNewYorkCurrentDateTime = ZonedDateTime.now(zoneAmericaNewYork);

        americaNewYorkNineOclock = ZonedDateTime.of ( americaNewYorkCurrentDateTime.toLocalDate() , LocalTime.of ( 9 , 00 ) , zoneAmericaNewYork );

        Date scheduledStartTime = Date.from(americaNewYorkNineOclock.toLocalDateTime().atZone(zoneAmericaNewYork).toInstant());

        //Schedule schedule = createMock(Schedule.class);
        schedule.setAllotedDurationMs(500);
        schedule.setAllotedBufferMs(null);
        expectLastCall();
        schedule.setScheduledStartTime(scheduledStartTime);
        expectLastCall();

        expect(user.getId()).andReturn(10);
        expect(user.getName()).andReturn("adminuser");
        expect(user.getUserType()).andReturn(UserType.ADMIN);
        expect(user.getUsername()).andReturn("administrator");
        expect(user.getPassword()).andReturn("Password1");
//        expect(schedule.getAllotedDurationMs()).andReturn(500).times(1);
//        expect(schedule.getAllotedBufferMs()).andReturn(null).times(1);
//        expect(schedule.getScheduledStartTime()).andReturn(scheduledStartTime).times(1);

        user.setSchedule(schedule);
        expectLastCall().times(1);


        // replay mocks
        mocks.forEach(EasyMock::replay);

        verifyAll();
    }
}
