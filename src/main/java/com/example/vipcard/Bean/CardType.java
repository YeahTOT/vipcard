package com.example.vipcard.Bean;

// 会员卡类型
public class CardType {
    // 会员卡类型id
    private int cardTypeId;
    // 顾客会员卡id
    private int userCardId;
    // 类型
    private String cardType;

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public int getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(int userCardId) {
        this.userCardId = userCardId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
