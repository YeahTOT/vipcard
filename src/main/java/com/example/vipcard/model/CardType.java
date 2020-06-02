package com.example.vipcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 会员卡类型
@Entity
@Table(name = "cardtype")
public class CardType {
    @Id
    @Column(name = "cardTypeId")
    private int cardTypeId;

    @Column(name = "cardType")
    private String cardType;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
