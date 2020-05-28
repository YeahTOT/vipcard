package com.example.vipcard.model;

// 排队进度表
public class ranking {
    // 排队进度id
    private int rankingId;
    // userOpenid
    private String userOpenid;
    // storeOpenid
    private String storeOpenid;
    // 排队总人数
    private int allNum;
    //当前排队人数
    private int nowNum;

    public int getRankingId() {
        return rankingId;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getStoreOpenid() {
        return storeOpenid;
    }

    public void setStoreOpenid(String storeOpenid) {
        this.storeOpenid = storeOpenid;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getNowNum() {
        return nowNum;
    }

    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }
}
