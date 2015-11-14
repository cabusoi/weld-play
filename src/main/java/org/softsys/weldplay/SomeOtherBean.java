package org.softsys.weldplay;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Audited
public class SomeOtherBean {

    @Inject
    Event<Long> events;

    @PostConstruct
    private void init() {
        System.out.println(this.getClass() + " initialized");
    }

    public void doSomething() {
        events.fire(Calendar.getInstance().getTimeInMillis());
    }
}
