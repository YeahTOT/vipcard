package com.example.vipcard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// 会员卡操作记录
@Entity
@Table(name = "cardrecord")
public class CardRecord {
    // 操作记录id
    @Id
    private int recordId;
    // 顾客会员卡Id
    private int userCardId;
    // 操作类型
    private String recordType;
    // 操作金额
    private Float recordMoney;
    // 操作次数
    private int recordTimes;
    // 操作积分
    private int recordScore;
    // 剩余金额
    private Float recordMoneySurplus;
    // 剩余积分
    private int recordTimesSurplus;
    // 剩余次数
    private int recordScoreSurplus;
    // 操作时间
    private String recordTime;

    public Float getRecordMoneySurplus() {
        return recordMoneySurplus;
    }

    public void setRecordMoneySurplus(Float recordMoneySurplus) {
        this.recordMoneySurplus = recordMoneySurplus;
    }

    public int getRecordTimesSurplus() {
        return recordTimesSurplus;
    }

    public void setRecordTimesSurplus(int recordTimesSurplus) {
        this.recordTimesSurplus = recordTimesSurplus;
    }

    public int getRecordScoreSurplus() {
        return recordScoreSurplus;
    }

    public void setRecordScoreSurplus(int recordScoreSurplus) {
        this.recordScoreSurplus = recordScoreSurplus;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public int getRecordTimes() {
        return recordTimes;
    }

    public void setRecordTimes(int recordTimes) {
        this.recordTimes = recordTimes;
    }

    public int getRecordScore() {
        return recordScore;
    }

    public void setRecordScore(int recordScore) {
        this.recordScore = recordScore;
    }

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

    public Float getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(Float recordMoney) {
        this.recordMoney = recordMoney;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "CardRecord{" +
                "recordId=" + recordId +
                ", userCardId=" + userCardId +
                ", recordType='" + recordType + '\'' +
                ", recordMoney=" + recordMoney +
                ", recordTimes=" + recordTimes +
                ", recordScore=" + recordScore +
                ", recordMoneySurplus=" + recordMoneySurplus +
                ", recordTimesSurplus=" + recordTimesSurplus +
                ", recordScoreSurplus=" + recordScoreSurplus +
                ", recordTime='" + recordTime + '\'' +
                '}';
    }
}
