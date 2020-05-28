package com.example.vipcard.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("store")
public class Store {
    // openid
    @Column("storeOpenid")
    private String storeOpenid;
    // 商家姓名
    @Column("storeUserName")
    private String storeUserName;
    // 商家logo
    @Column("storeLogo")
    private String storeLogo;
    // 商家地址
    @Column("storeAddress")
    private String storeAddress;
    // 商家电话
    @Column("storePhone")
    private String storePhone;
    // 商家介绍
    @Column("storeNode")
    private String storeNode;
    // 商家姓名
    @Column("storeName")
    private String storeName;
    // 商家类型
    @Column("storeType")
    private String storeType;

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreOpenid() {
        return storeOpenid;
    }

    public void setStoreOpenid(String storeOpenid) {
        this.storeOpenid = storeOpenid;
    }

    public String getStoreUserName() {
        return storeUserName;
    }

    public void setStoreUserName(String storeUserName) {
        this.storeUserName = storeUserName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreNode() {
        return storeNode;
    }

    public void setStoreNode(String storeNode) {
        this.storeNode = storeNode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
