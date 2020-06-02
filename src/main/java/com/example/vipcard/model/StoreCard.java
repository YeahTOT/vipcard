package com.example.vipcard.model;

import javax.persistence.*;

import java.util.Collection;

// 商家创建的会员卡
@Entity
@Table(name = "storecard")
public class StoreCard {
    // 会员卡id
    @Id
    @Column(name = "storeCardId")
    private int storeCardId;
    // 商家id
//    @Column(name = "storeOpenid")
//    private String storeOpenid;
    // 会员卡名称
    @Column(name = "cardName")
    private String cardName;
    // 会员卡类型
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "storecard_cardtype", joinColumns = @JoinColumn(name = "storeCardId"),
            inverseJoinColumns = @JoinColumn(name = "cardTypeId"))
    private Collection<CardType> cardTypes;
    // 会员卡开始时间
    @Column(name = "cardTimeStart")
    private String cardTimeStart;
    // 会员卡截至时间
    @Column(name = "cardTimeEnd")
    private String cardTimeEnd;
    // 会员卡状态
    @Column(name = "cardStatus")
    private String cardStatus;
    // 会会员卡备注
    @Column(name = "cardNode")
    private String cardNode;
    // 会员卡剩余数量
    @Column(name = "cardSurplus")
    private int cardSurplus;
    // 会员卡发卡总数
    @Column(name = "cardNum")
    private int cardNum;
    // 会员卡logo
    @Column(name = "cardLogo")
    private String cardLogo;

//    // 对应的商家
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "storeOpenid")//设置在article表中的关联字段(外键)
    private Store store;

//    @OneToMany(mappedBy = "sCard",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private Collection<UserCard> userCards;//文章列表

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getStoreCardId() {
        return storeCardId;
    }

    public void setStoreCardId(int storeCardId) {
        this.storeCardId = storeCardId;
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
