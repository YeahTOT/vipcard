package com.example.vipcard.model;

import javax.persistence.*;
import java.util.Collection;

// 会员卡类型
@Entity
@Table(name = "cardtype")
public class CardType {
    @Id
    @Column(name = "cardTypeId")
    private int cardTypeId;

    @Column(name = "cardType")
    private String cardType;

    // 多对多关系
    @ManyToMany(mappedBy = "cardTypes")
    private Collection<StoreCard> storeCards;


    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CardType{" +
                "cardTypeId=" + cardTypeId +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
