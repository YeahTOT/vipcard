package com.example.vipcard.repository;

import com.example.vipcard.model.Store;
import com.example.vipcard.model.StoreCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Transactional
public interface StoreCardRepository extends JpaRepository<StoreCard, Integer> {

    // 根据openid查询该管理员的所有会员卡信息
    @Query("select scard from StoreCard scard where scard.store.storeOpenid = :storeOpenId")
    Collection<StoreCard> findStoreCardByOpenId(@Param("storeOpenId") String storeOpenId);

    // 更具cardId查询该会员卡的信息
    @Query("select scard from StoreCard scard where scard.storeCardId = :storeCardId")
    StoreCard findStoreCardByStoreCardId(@Param("storeCardId") int storeCardId);

    // 根据storeCardId删除会员卡
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM storeCard WHERE storeCardId = :storeCardId ")
    int deleteStoreCardByStoreCardId(int storeCardId);
}
