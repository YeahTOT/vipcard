package com.example.vipcard.service;

import com.example.vipcard.model.Store;
import com.example.vipcard.model.StoreType;
import com.example.vipcard.model.User;
import com.example.vipcard.repository.StoreRepository;
import com.example.vipcard.repository.StoreTypeRepository;
import com.example.vipcard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VipCardServiceImpl implements VipCardService {

    // 注入repository
    private UserRepository userRepository;
    private StoreTypeRepository storeTypeRepository;
    private StoreRepository storeRepository;

    public VipCardServiceImpl(UserRepository userRepository, StoreTypeRepository storeTypeRepository, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.storeTypeRepository = storeTypeRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public Collection<User> getAllUsers() {
        return (Collection<User>) userRepository.findAll();
    }

    @Override
    public Collection<StoreType> getAllStoreTypes() {
        return (Collection<StoreType>) storeTypeRepository.findAll();
    }

    @Override
    public Collection<Store> getAllStores() {
        return (Collection<Store>) storeRepository.findAll();
    }

    @Override
    public Collection<Store> getStoresByOpenId(String openid) {
        return storeRepository.findByStoreOpenid(openid);
    }

}
