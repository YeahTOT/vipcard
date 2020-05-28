package com.example.vipcard.service;

import com.example.vipcard.model.Store;
import com.example.vipcard.model.StoreType;
import com.example.vipcard.model.User;

import java.util.Collection;

public interface VipCardService {
    public Collection<User> getAllUsers();
    public Collection<StoreType> getAllStoreTypes();
    public Collection<Store> getAllStores();
    public Collection<Store> getStoresByOpenId(String openid);
    public Store addStore(Store store);
}
