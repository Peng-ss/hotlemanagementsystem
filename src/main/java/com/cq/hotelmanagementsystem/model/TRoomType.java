package com.cq.hotelmanagementsystem.model;

import java.math.BigDecimal;

public class TRoomType {
    private Integer id;

    private String roomTypeName;

    private BigDecimal price;

    private Integer discount;

    private Boolean isWindow;

    private String remanks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName == null ? null : roomTypeName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getIsWindow() {
        return isWindow;
    }

    public void setIsWindow(Boolean isWindow) {
        this.isWindow = isWindow;
    }

    public String getRemanks() {
        return remanks;
    }

    public void setRemanks(String remanks) {
        this.remanks = remanks == null ? null : remanks.trim();
    }
}