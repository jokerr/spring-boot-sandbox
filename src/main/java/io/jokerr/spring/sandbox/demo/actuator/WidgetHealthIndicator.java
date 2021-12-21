package io.jokerr.spring.sandbox.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class WidgetHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if(2 + 2 == 5) {
            return Health.down().withDetail("widgetHealth", "Extremely large values of 2 found!").build();
        }
        return Health.up().build();
    }
}
