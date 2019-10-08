package ru.project.accountsystem.services.impl;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import ru.project.accountsystem.services.DateService;

import java.util.TimeZone;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Admin on 05.05.2019.
 */
public class JodaDateService implements DateService {

    private final DateTimeZone timeZone;

    public JodaDateService(final DateTimeZone timeZone) {
        super();
        this.timeZone = checkNotNull(timeZone);
        System.setProperty("user.timezone", timeZone.getID());
        TimeZone.setDefault(timeZone.toTimeZone());
        DateTimeZone.setDefault(timeZone);
    }

    @Override
    public DateTime now() {
        return DateTime.now(timeZone);
    }
}
