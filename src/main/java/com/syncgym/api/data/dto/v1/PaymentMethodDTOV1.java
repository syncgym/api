package com.syncgym.api.data.dto.v1;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PaymentMethodDTOV1 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;

    public PaymentMethodDTOV1(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public PaymentMethodDTOV1() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodDTOV1 that = (PaymentMethodDTOV1) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
