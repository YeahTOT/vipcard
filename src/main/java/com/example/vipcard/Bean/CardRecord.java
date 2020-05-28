package com.example.vipcard.Bean;

import java.util.Date;

// 会员卡操作记录
public class CardRecord {
    // 操作记录id
    private int recordId;
    // 顾客会员卡Id
    private int userCardId;
    // 操作类型
    private String recordTypr;
    // 操作金额
    private Float recordMoney;
    // 操作时间
    private Date recordTime;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(int userCardId) {
        this.userCardId = userCardId;
    }

    public String getRecordTypr() {
        return recordTypr;
    }

    public void setRecordTypr(String recordTypr) {
        this.recordTypr = recordTypr;
    }

    public Float getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(Float recordMoney) {
        this.recordMoney = recordMoney;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
