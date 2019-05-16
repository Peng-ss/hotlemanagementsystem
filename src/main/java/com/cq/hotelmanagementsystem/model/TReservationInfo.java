package com.cq.hotelmanagementsystem.model;

import java.util.Date;

public class TReservationInfo {
    private Integer id;

<<<<<<< HEAD
    private Integer guestroomId;
=======
    private String guestroomId;
>>>>>>> 完成

    private String reservationName;

    private String teleNum;

    private Date checkinTime;

    private Date checkoutTime;

    private String remanks;

<<<<<<< HEAD
=======
    private Integer guestroomTypeId;

    private String roomTypeName;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getGuestroomTypeId() {
        return guestroomTypeId;
    }

    public void setGuestroomTypeId(Integer guestroomTypeId) {
        this.guestroomTypeId = guestroomTypeId;
    }

>>>>>>> 完成
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Integer getGuestroomId() {
        return guestroomId;
    }

    public void setGuestroomId(Integer guestroomId) {
=======
    public String getGuestroomId() {
        return guestroomId;
    }

    public void setGuestroomId(String guestroomId) {
>>>>>>> 完成
        this.guestroomId = guestroomId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName == null ? null : reservationName.trim();
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum == null ? null : teleNum.trim();
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

    public String getRemanks() {
        return remanks;
    }

    public void setRemanks(String remanks) {
        this.remanks = remanks == null ? null : remanks.trim();
    }
}