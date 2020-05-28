package com.example.vipcard.model;

public class StoreCard {
    // 会员卡id
    private int storeCardId;
    // 商家id
    private String storeOpenid;
    // 会员卡名称
    private String cardName;
    // 会员卡类型
    private String cardType;
    // 会员卡开始时间
    private String cardTimeStart;
    // 会员卡截至时间
    private String cardTimeEnd;
    // 会员卡状态
    private String cardStatus;
    // 会会员卡备注
    private String cardNode;
    // 会员卡剩余数量
    private int surplus;
    // 会员卡发卡总数
    private int num;

    public int getStoreCardId() {
        return storeCardId;
    }

    public void setStoreCardId(int storeCardId) {
        this.storeCardId = storeCardId;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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
}
