package com.syncgym.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_subscription")
    private Subscription subscription;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String invoice;

    public Payment(long id, PaymentMethod paymentMethod, Subscription subscription, int value, Date date, String invoice) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.subscription = subscription;
        this.value = value;
        this.date = date;
        this.invoice = invoice;
    }

    public Payment() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && value == payment.value && Objects.equals(paymentMethod, payment.paymentMethod) && Objects.equals(subscription, payment.subscription) && Objects.equals(date, payment.date) && Objects.equals(invoice, payment.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentMethod, subscription, value, date, invoice);
    }
}
