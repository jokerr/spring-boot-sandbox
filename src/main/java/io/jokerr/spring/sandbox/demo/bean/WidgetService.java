package io.jokerr.spring.sandbox.demo.bean;

import io.jokerr.spring.sandbox.demo.model.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class WidgetService {

    public List<Widget> getWidgets() {
        List<Widget> widgets = new ArrayList<>(3);
        for(int i = 0; i < 3; i++) {
            String uuid = UUID.randomUUID().toString();
            widgets.add(new Widget(uuid, uuid));
        }
        return Collections.unmodifiableList(widgets);
    }

    public Widget getWidget(String widgetId) {
        return new Widget(widgetId, widgetId);
    }
}
