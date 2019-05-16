package com.cq.hotelmanagementsystem.model;

import java.math.BigDecimal;
import java.util.Date;

public class TBillInfo {
    private Integer id;

    private String billNum;

    private String guestroomNum;

    private Integer customerId;

    private Date checkinTime;

    private Date checkoutTime;

    private BigDecimal payPrice;

<<<<<<< HEAD
    private String ramanks;
=======
    private String remanks;

    private Boolean isPay;

    public Boolean getPay() {
        return isPay;
    }

    public void setPay(Boolean pay) {
        isPay = pay;
    }
>>>>>>> 完成

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum == null ? null : billNum.trim();
    }

    public String getGuestroomNum() {
        return guestroomNum;
    }

    public void setGuestroomNum(String guestroomNum) {
        this.guestroomNum = guestroomNum == null ? null : guestroomNum.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

<<<<<<< HEAD
    public String getRamanks() {
        return ramanks;
    }

    public void setRamanks(String ramanks) {
        this.ramanks = ramanks == null ? null : ramanks.trim();
=======
    public String getRemanks() {
        return remanks;
    }

    public void setRemanks(String remanks) {
        this.remanks = remanks == null ? null : remanks.trim();
>>>>>>> 完成
    }
}