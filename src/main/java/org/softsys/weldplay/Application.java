package org.softsys.weldplay;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application {

    private static Logger logger = Logger
            .getLogger(Application.class.getName());

    @Inject
    @New
    private SomeOtherBean injectedBean;

    @Produces
    @Alternative
    SomeOtherBean getBean() {
        return new SomeOtherBean();
    }

    public void run() {
        injectedBean.doSomething();

    }

    public void eventReceived(@Observes Long date) {
        System.out.println(date);
    }
}