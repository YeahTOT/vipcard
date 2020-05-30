package com.example.vipcard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// 用户会员卡
@Table("usercard")
public class UserCard extends StoreCard{
    // 会员卡id
    @Id
    @Column("userCardId")
    private int userCardId;
    // 用户openid
    @Column("userOpenid")
    private String userOpenid;
    // 会员卡剩余金额
    @Column("cardMoney")
    private double cardMoney;
    // 会员卡剩余积分
    @Column("cardScore")
    private double cardScore;
    // 会员卡剩余次数
    @Column("cardTimes")
    private int cardTimes;


    public int getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(int userCardId) {
        this.userCardId = userCardId;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public double getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(double cardMoney) {
        this.cardMoney = cardMoney;
    }

    public double getCardScore() {
        return cardScore;
    }

    public void setCardScore(double cardScore) {
        this.cardScore = cardScore;
    }

    public int getCardTimes() {
        return cardTimes;
    }

    public void setCardTimes(int cardTimes) {
        this.cardTimes = cardTimes;
    }
}
