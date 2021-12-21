package io.jokerr.spring.sandbox.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReadinessStateLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadinessStateLogger.class);

    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        if(ReadinessState.ACCEPTING_TRAFFIC.equals(event.getState())) {
            LOGGER.info("Application is now ready for traffic");
        }
        else if(ReadinessState.REFUSING_TRAFFIC.equals(event.getState())) {
            LOGGER.info("Application is refusing traffic");
        }
    }
}
