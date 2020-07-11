package com.example.vipcard.service;

import com.example.vipcard.model.*;

import java.util.Collection;
import java.util.Date;

public interface VipCardService {
    // 获取所有的用户
    public Collection<User> getAllUsers();

    // 获取所有的商家类型
    public Collection<StoreType> getAllStoreTypes();
    // 增加一个商家类型
    public StoreType addStoreType(StoreType storeType);

    // 获取所有的商家
    public Collection<Store> getAllStores();
    // 根据openid查找所有的商家
    public Store getStoresByOpenId(String openid);
    // 增加商家信息
    public Store addStore(Store store);
    // 修改商家信息
    public boolean updateStore(Store store);


    // 获取所有的商家会员卡
    public Collection<StoreCard> getAllStoreCards();
    // 根据商家的openid获取会员卡信息
    public Collection<StoreCard> getStoreCardByOpenId(String openid);
    // 根据会员卡的storeCardId查询会员卡信息s
    public StoreCard getStoreCardById(int storeCardId);
    // 商家创建一张会员卡
    public StoreCard addStoreCard(StoreCard storeCard);

    // 获取所有的用户会员卡
    public Collection<UserCard> getAllUserCards();
    // 根据openid查找该用户的会员卡
    public Collection<UserCard> getUserCardByOpenid(String openid);
    // 增加用户的会员卡
    public UserCard addUserCard(UserCard userCard);
    // 删除会员卡
    public boolean delUserCard(int userCardId);


    // 根据userCardId查询某一张会员卡
    public UserCard getUserCardByUserCardId(int userCardId);


    //  获取所有会员卡操作记录
    public Collection<CardRecord> getCardRecords();
    // 根据userCardId查找该卡的所有操作记录
    public Collection<CardRecord> getCardRecordsByUserCardId(int userCardId);
    // 更具userCardId查找该卡的某一时间段的操作记录
    public Collection<CardRecord> getCardRecordsByUserCardIdANDDate(int userCardId, String dateStart, String dataEnd);

    // 用于测试 查询所有的排队记录
    public Collection<Ranking> getAllRankings();
    // 商家查询自己店铺的所有排队记录
    public Collection<Ranking> getAllRankingsByStoreOpenid(String storeOpenid);
    // 用户查询自己的排队进度
    public Integer getRankingByUserOpenidAndStoreOpenid(String userOpenid, String storeOpenid);
    // 获取store排队总人数
    public int getRankingNumByStoreOpenid(String storeOpenid);
    // 用户申请排队
    public boolean userAddRanking(String userOpenid,String storeOpenid);
    // 商家叫号 删除排名第一的人的ranking
    public Integer storeDelUserRanking(String storeOpenid);

    // 用户查询自己的排队进度
    Integer getRankingByUserOpenid(String userOpenid);
    // 用户查询自己正在预约的杀郭嘉
    Collection<Store> findStoreByUser(String userOpenid);
    // 用户取消预约
    boolean cancelByUser(String userOpenid);
}
