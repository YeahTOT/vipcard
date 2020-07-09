package com.example.vipcard.repository;

import com.example.vipcard.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    // 根据openid查找对应的store信息
    @Query("select store from Store store where store.storeOpenid = :openid")
    Store findByStoreOpenid(@Param("openid") String openid);

    // 更具openid修改对应的store信息
    @Modifying
    @Transactional
    @Query("update Store s set " +
            "s.storeUserName = CASE WHEN :#{#store.storeUserName} IS NULL THEN s.storeUserName ELSE :#{#store.storeUserName} END ," +
            "s.storeLogo = CASE WHEN :#{#store.storeLogo} IS NULL THEN s.storeLogo ELSE :#{#store.storeLogo} END ," +
            "s.storeAddress = CASE WHEN :#{#store.storeAddress} IS NULL THEN s.storeAddress ELSE :#{#store.storeAddress} END ," +
            "s.storePhone = CASE WHEN :#{#store.storePhone} IS NULL THEN s.storePhone ELSE :#{#store.storePhone} END ," +
            "s.storeNode = CASE WHEN :#{#store.storeNode} IS NULL THEN s.storeNode ELSE :#{#store.storeNode} END ," +
            "s.storeName = CASE WHEN :#{#store.storeName} IS NULL THEN s.storeName ELSE :#{#store.storeName} END ," +
            "s.storeType = CASE WHEN :#{#store.storeType} IS NULL THEN s.storeType ELSE :#{#store.storeType} END " +
            "where s.storeOpenid = :#{#store.storeOpenid}")
    int updateByStoreOpenid(@Param("store") Store store);

    @Query("select ranking.store from Ranking ranking where ranking.user.userOpenid = :userOpenid")
    Collection<Store> findStoreOpenidByUser(String userOpenid);


}
