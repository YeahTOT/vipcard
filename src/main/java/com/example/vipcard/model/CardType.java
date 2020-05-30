package com.example.vipcard.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// 会员卡类型
@Table("cardtype")
public class CardType {
    @Column("cardType")
    private String cardType;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
