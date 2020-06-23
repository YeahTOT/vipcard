package com.example.vipcard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// 商家类型
@Table("storetype")
public class StoreType {
    // 类型id
    @Id
    @Column("storeTypeId")
    private int storeTypeId;
    @Column("storeType")
    private String storeType;


    public int getStoreTypeId() {
        return storeTypeId;
    }

    public void setStoreTypeId(int storeTypeId) {
        this.storeTypeId = storeTypeId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    @Override
    public String toString() {
        return "StoreType{" +
                "storeTypeId=" + storeTypeId +
                ", storeType='" + storeType + '\'' +
                '}';
    }
}
