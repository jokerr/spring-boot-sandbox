package io.jokerr.spring.sandbox.demo.actuator;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
@WebEndpoint(id = "widget")
public class WidgetStatsEndpoint {

    @ReadOperation
    public WidgetStats pullStats() {
        WidgetStats widgetStats = new WidgetStats();
        widgetStats.getStats().put("count", new Random().nextInt());
        return widgetStats;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class WidgetStats {
        private Map<String, Object> stats = new HashMap<>();

        public WidgetStats() {
            //no-op
        }

        public Map<String, Object> getStats() {
            return stats;
        }
    }
}
