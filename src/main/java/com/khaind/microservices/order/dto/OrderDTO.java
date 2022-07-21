package com.khaind.microservices.order.dto;

public class OrderDTO {

    private Long id;

    private Long userId;

    private Long price;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
