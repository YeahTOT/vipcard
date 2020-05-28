package com.example.vipcard.model;

// 会员卡等级规则
public class cardGrading {
    // 主键
    private String id;
    // 商家会员卡id
    private int storeCardId;
    // 规则最小值
    private float ruleListMin;
    // 规则最大值
    private float ruleListMax;
    // 会员卡等级
    private String grading;
    // 折扣
    private float discount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStoreCardId() {
        return storeCardId;
    }

    public void setStoreCardId(int storeCardId) {
        this.storeCardId = storeCardId;
    }

    public float getRuleListMin() {
        return ruleListMin;
    }

    public void setRuleListMin(float ruleListMin) {
        this.ruleListMin = ruleListMin;
    }

    public float getRuleListMax() {
        return ruleListMax;
    }

    public void setRuleListMax(float ruleListMax) {
        this.ruleListMax = ruleListMax;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
