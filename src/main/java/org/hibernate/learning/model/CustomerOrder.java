package org.hibernate.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {

    @Id
    private int id;

    private String orderCode;

    private String trackingNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public CustomerOrder(int id, String orderCode, String trackingNumber) {
        this.id = id;
        this.orderCode = orderCode;
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" + "id=" + id + ", orderCode='" + orderCode + '\'' + ", trackingNumber='"
            + trackingNumber + '\'' + '}';
    }
}
