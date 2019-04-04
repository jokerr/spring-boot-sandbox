package io.jokerr.spring.sandbox.demo.model;

import java.util.Objects;

public class Widget {
    private String id;
    private String name;

    public Widget(String name) {
        this.name = name;
    }

    public Widget(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Widget widget = (Widget) o;
        return Objects.equals(id, widget.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
