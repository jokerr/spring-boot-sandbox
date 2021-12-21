package io.jokerr.spring.sandbox.demo.controller;

import io.jokerr.spring.sandbox.demo.bean.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/widget")
public class WidgetController {

    @Autowired
    private WidgetService service;

    @GetMapping
    public ResponseEntity getWidgets() {
        return ResponseEntity.ok(service.getWidgets());
    }

    @GetMapping("/{widgetId}")
    public ResponseEntity getWidget(@PathVariable("widgetId") int widgetId) {
        return ResponseEntity.ok(service.getWidget(widgetId));
    }
}
