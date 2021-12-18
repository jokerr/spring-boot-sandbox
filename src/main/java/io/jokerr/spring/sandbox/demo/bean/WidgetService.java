package io.jokerr.spring.sandbox.demo.bean;

import io.jokerr.spring.sandbox.demo.model.Widget;
import io.jokerr.spring.sandbox.demo.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    private WidgetRepository repository;

    public List<Widget> getWidgets() {
        return repository.getWidgets();
    }

    public Widget getWidget(int widgetId) {
        return repository.getWidget(widgetId);
    }
}
