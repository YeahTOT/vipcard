package com.example.vipcard.service;

import com.example.vipcard.model.*;

import java.util.Collection;

public interface VipCardService {
    // 获取所有的用户
    public Collection<User> getAllUsers();
    // 获取所有的商家类型
    public Collection<StoreType> getAllStoreTypes();
    // 获取所有的商家
    public Collection<Store> getAllStores();
    // 根据openid查找所有的商家
    public Collection<Store> getStoresByOpenId(String openid);
    // 增加商家信息
    public Store addStore(Store store);
    // 获取所有的商家会员卡
    public Collection<StoreCard> getAllStoreCards();
    // 根据商家的openid获取会员卡信息
    public Collection<StoreCard> getStoreCardByOpenId(String openid);
    // 获取所有的用户会员卡
    public Collection<UserCard> getAllUserCards();
    // 根据openid查找该用户的会员卡
    public Collection<UserCard> getUserCardByOpenid(String openid);
    // 根据userCardId查询某一张会员卡
    public UserCard getUserCardByUserCardId(int userCardId);

}
