package com.syncgym.api.plan;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Plan implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double value;

    public Plan(Long id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Plan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id) && Objects.equals(value, plan.value) && Objects.equals(name, plan.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }
}
