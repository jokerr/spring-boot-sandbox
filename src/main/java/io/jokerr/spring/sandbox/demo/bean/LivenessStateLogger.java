package io.jokerr.spring.sandbox.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LivenessStateLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(LivenessStateLogger.class);

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<LivenessState> event) {
        if(LivenessState.BROKEN.equals(event.getState())) {
            LOGGER.info("Application is not 'alive'.");
        }
        else if(LivenessState.CORRECT.equals(event.getState())) {
            LOGGER.info("Application is now correct and 'alive'.");
        }
    }
}
