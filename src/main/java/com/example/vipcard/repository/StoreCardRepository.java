package com.example.vipcard.repository;

import com.example.vipcard.model.Store;
import com.example.vipcard.model.StoreCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StoreCardRepository extends CrudRepository<StoreCard, Integer> {

    @Query("select scard from StoreCard scard where scard.store.storeOpenid = :storeOpenId")
    Collection<StoreCard> findStoreCardByOpenId(@Param("storeOpenId") String storeOpenId);
}
