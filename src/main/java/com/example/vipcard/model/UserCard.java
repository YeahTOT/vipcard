package com.example.vipcard.model;

import javax.persistence.*;

// 用户会员卡
@Entity
@Table(name = "usercard")
public class UserCard {
    // 会员卡id
    @Id
    @Column(name = "userCardId",insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCardId;
//    @Column(name = "storeCardId")
//    private int storeCardId;
    // 用户openid
    @Column(name = "userOpenid")
    private String userOpenid;
    // 会员卡剩余金额
    @Column(name = "cardMoney")
    private double cardMoney;
    // 会员卡剩余积分
    @Column(name = "cardScore")
    private double cardScore;
    // 会员卡剩余次数
    @Column(name = "cardTimes")
    private int cardTimes;

    @ManyToOne(optional=false)
    @JoinColumn(name="storeCardId")//设置在article表中的关联字段(外键)
    private StoreCard storeCard;

    public StoreCard getStoreCard() {
        return storeCard;
    }

    public void setStoreCard(StoreCard storeCard) {
        this.storeCard = storeCard;
    }

    public int getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(int userCardId) {
        this.userCardId = userCardId;
    }
//    public int getUserCardId() {
//        return userCardId;
//    }
//
//    public void setUserCardId(int userCardId) {
//        this.userCardId = userCardId;
//    }

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

    @Override
    public String toString() {
        return "UserCard{" +
                "userCardId=" + userCardId +
                ", userOpenid='" + userOpenid + '\'' +
                ", cardMoney=" + cardMoney +
                ", cardScore=" + cardScore +
                ", cardTimes=" + cardTimes +
                ", storeCard=" + storeCard +
                '}';
    }
}
