package com.example.vipcard.service;

import com.example.vipcard.model.*;
import com.example.vipcard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VipCardServiceImpl implements VipCardService {

    // 注入repository
    private UserRepository userRepository;
    private StoreTypeRepository storeTypeRepository;
    private StoreRepository storeRepository;
    private StoreCardRepository storeCardRepository;
    private UserCardRepository userCardRepository;

    @Autowired
    public VipCardServiceImpl(UserRepository userRepository, StoreTypeRepository storeTypeRepository, StoreRepository storeRepository, StoreCardRepository storeCardRepository, UserCardRepository userCardRepository) {
        this.userRepository = userRepository;
        this.storeTypeRepository = storeTypeRepository;
        this.storeRepository = storeRepository;
        this.storeCardRepository = storeCardRepository;
        this.userCardRepository = userCardRepository;
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

    @Override
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Collection<StoreCard> getAllStoreCards() {
        return (Collection<StoreCard>) storeCardRepository.findAll();
    }

    @Override
    public Collection<StoreCard> getStoreCardByOpenId(String openid) {
        return storeCardRepository.findStoreCardByOpenId(openid);
    }

    @Override
    public Collection<UserCard> getAllUserCards() {
        return (Collection<UserCard>)userCardRepository.findAll();
    }

    @Override
    public Collection<UserCard> getUserCardByOpenid(String openid) {
        return userCardRepository.findUserCardsByOpenId(openid);
    }

    @Override
    public UserCard getUserCardByUserCardId(int userCardId) {
        return userCardRepository.findUserCardByUserCardId(userCardId);
    }


}
