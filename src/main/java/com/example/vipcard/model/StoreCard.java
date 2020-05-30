package com.example.vipcard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

// 商家创建的会员卡
@Table("storecard")
public class StoreCard {
    // 会员卡id
    @Id
    @Column("storeCardId")
    private int storeCardId;
    // 商家id
    @Column("storeOpenid")
    private String storeOpenid;
    // 会员卡名称
    @Column("cardName")
    private String cardName;
    // 会员卡类型
    @MappedCollection(idColumn = "storeCardId",keyColumn="cardType")
    private Collection<CardType> cardTypes;
    // 会员卡开始时间
    @Column("cardTimeStart")
    private String cardTimeStart;
    // 会员卡截至时间
    @Column("cardTimeEnd")
    private String cardTimeEnd;
    // 会员卡状态
    @Column("cardStatus")
    private String cardStatus;
    // 会会员卡备注
    @Column("cardNode")
    private String cardNode;
    // 会员卡剩余数量
    @Column("cardSurplus")
    private int cardSurplus;
    // 会员卡发卡总数
    @Column("cardNum")
    private int cardNum;
    // 会员卡logo
    @Column("cardLogo")
    private String cardLogo;

    public int getStoreCardId() {
        return storeCardId;
    }

    public void setStoreCardId(int storeCardId) {
        this.storeCardId = storeCardId;
    }

    public String getStoreOpenid() {
        return storeOpenid;
    }

    public void setStoreOpenid(String storeOpenid) {
        this.storeOpenid = storeOpenid;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardTimeStart() {
        return cardTimeStart;
    }

    public void setCardTimeStart(String cardTimeStart) {
        this.cardTimeStart = cardTimeStart;
    }

    public String getCardTimeEnd() {
        return cardTimeEnd;
    }

    public void setCardTimeEnd(String cardTimeEnd) {
        this.cardTimeEnd = cardTimeEnd;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardNode() {
        return cardNode;
    }

    public void setCardNode(String cardNode) {
        this.cardNode = cardNode;
    }

    public int getCardSurplus() {
        return cardSurplus;
    }

    public void setCardSurplus(int cardSurplus) {
        this.cardSurplus = cardSurplus;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardLogo() {
        return cardLogo;
    }

    public void setCardLogo(String cardLogo) {
        this.cardLogo = cardLogo;
    }

    public Collection<CardType> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(Collection<CardType> cardTypes) {
        this.cardTypes = cardTypes;
    }
}
