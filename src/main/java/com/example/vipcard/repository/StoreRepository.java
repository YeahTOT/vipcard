package com.example.vipcard.repository;

import com.example.vipcard.model.Store;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StoreRepository extends CrudRepository<Store, Integer> {

    @Query("select * from store where storeOpenId = :openid")
    Collection<Store> findByStoreOpenid(@Param("openid") String openid);

}
