package com.example.vipcard.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "store")
public class Store {
    // openid
    @Id
    @Column(name = "storeOpenid")
    private String storeOpenid;
    // 商家姓名
    @Column(name = "storeUserName")
    private String storeUserName;
    // 商家logo
    @Column(name = "storeLogo")
    private String storeLogo;
    // 商家地址
    @Column(name = "storeAddress")
    private String storeAddress;
    // 商家电话
    @Column(name = "storePhone")
    private String storePhone;
    // 商家介绍
    @Column(name = "storeNode")
    private String storeNode;
    // 商家姓名
    @Column(name = "storeName")
    private String storeName;
    // 商家类型
    @Column(name = "storeType")
    private String storeType;

//    @OneToMany(mappedBy = "store",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private Collection<StoreCard> storeCards;//文章列表

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

    @Override
    public String toString() {
        return "Store{" +
                "storeOpenid='" + storeOpenid + '\'' +
                ", storeUserName='" + storeUserName + '\'' +
                ", storeLogo='" + storeLogo + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeNode='" + storeNode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeType='" + storeType + '\'' +
                '}';
    }
}
