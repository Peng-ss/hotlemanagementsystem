package com.cq.hotelmanagementsystem.model;

import java.util.Date;

public class TCustomerInfo {
    private Integer id;

    private String customerName;

    private Boolean sex;

    private String teleNum;

    private String certificatesNum;

    private Date creationTime;

    private String remanks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum == null ? null : teleNum.trim();
    }

    public String getCertificatesNum() {
        return certificatesNum;
    }

    public void setCertificatesNum(String certificatesNum) {
        this.certificatesNum = certificatesNum == null ? null : certificatesNum.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getRemanks() {
        return remanks;
    }

    public void setRemanks(String remanks) {
        this.remanks = remanks == null ? null : remanks.trim();
    }
}