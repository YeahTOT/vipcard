package com.example.vipcard.model;

import javax.persistence.*;


import java.util.Collection;

// 用户会员卡
@Entity
@Table(name = "usercardView")
public class UserCard {
    // 会员卡id
    @Id
    @Column(name = "userCardId")
    private int userCardId;
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

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="storeCardId")//设置在article表中的关联字段(外键)
    private StoreCard sCard;


    public StoreCard getsCard() {
        return sCard;
    }

    public void setsCard(StoreCard sCard) {
        this.sCard = sCard;
    }

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
