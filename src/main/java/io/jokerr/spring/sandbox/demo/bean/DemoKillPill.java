package io.jokerr.spring.sandbox.demo.bean;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DemoKillPill {
    private final ApplicationEventPublisher eventPublisher;

    public DemoKillPill(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void doCheck() {
       if(2+2 == 5) {
           // extremely large values of 2 found, abort!
            AvailabilityChangeEvent.publish(this.eventPublisher,
                    new Exception("Large values of 2 found"),
                    LivenessState.BROKEN);
        }
    }
}
