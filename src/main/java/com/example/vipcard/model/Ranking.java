package com.example.vipcard.model;

import javax.persistence.*;
import java.util.Date;

// 排队进度表
@Entity
@Table(name="ranking")
public class Ranking {
    // 排队进度id
    @Id
    private int rankingId;
    // userOpenid
    @ManyToOne(optional=false)//
    @JoinColumn(name = "userOpenid")//
    private User user;
    // storeOpenid
    @ManyToOne(optional=false)//
    @JoinColumn(name = "storeOpenid")//
    private Store store;
    // 开始排队的时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date rankingTime;

    public Ranking() {
    }

    public Date getRankingTime() {
        return rankingTime;
    }

    public void setRankingTime(Date rankingTime) {
        this.rankingTime = rankingTime;
    }

    public int getRankingId() {
        return rankingId;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "user=" + user +
                ", store=" + store +
                ", rankingTime=" + rankingTime +
                '}';
    }
}
