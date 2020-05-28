package com.example.vipcard.model;

public class UserCard extends StoreCard{
    // 会员卡id
    private int userCardId;
    // 用户openid
    private String userOpenid;
    // 会员卡剩余金额
    private String cardMoney;
    // 会员卡剩余积分
    private String cardScore;


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

    public String getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(String cardMoney) {
        this.cardMoney = cardMoney;
    }

    public String getCardScore() {
        return cardScore;
    }

    public void setCardScore(String cardScore) {
        this.cardScore = cardScore;
    }
}
