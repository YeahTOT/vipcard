package com.example.vipcard.repository;

import com.example.vipcard.model.Store;
import com.example.vipcard.model.StoreCard;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StoreCardRepository extends CrudRepository<StoreCard, Integer> {

    @Query("select * from storecard where storeOpenId = :openid")
    Collection<StoreCard> findStoreCardByOpenId(@Param("openid") String openid);
}
