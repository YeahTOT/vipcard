package com.example.vipcard.service;

import com.example.vipcard.model.*;
import com.example.vipcard.repository.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class VipCardServiceImpl implements VipCardService {

    // 注入repository
    private UserRepository userRepository;
    private StoreTypeRepository storeTypeRepository;
    private StoreRepository storeRepository;
    private StoreCardRepository storeCardRepository;
    private UserCardRepository userCardRepository;
    private CardRecordRepository cardRecordRepository;
    private RankingRepository rankingRepository;

    public VipCardServiceImpl(UserRepository userRepository, StoreTypeRepository storeTypeRepository, StoreRepository storeRepository, StoreCardRepository storeCardRepository, UserCardRepository userCardRepository, CardRecordRepository cardRecordRepository, RankingRepository rankingRepository) {
        this.userRepository = userRepository;
        this.storeTypeRepository = storeTypeRepository;
        this.storeRepository = storeRepository;
        this.storeCardRepository = storeCardRepository;
        this.userCardRepository = userCardRepository;
        this.cardRecordRepository = cardRecordRepository;
        this.rankingRepository = rankingRepository;
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
    public StoreType addStoreType(StoreType storeType) {
        return storeTypeRepository.save(storeType);
    }

    @Override
    public Collection<Store> getAllStores() {
        return (Collection<Store>) storeRepository.findAll();
    }

    @Override
    public Store getStoresByOpenId(String openid) {
        return storeRepository.findByStoreOpenid(openid);
    }

    @Override
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public boolean updateStore(Store store) {
        return storeRepository.updateByStoreOpenid(store) == 1;
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
    public StoreCard getStoreCardById(int storeCardId) {
        return storeCardRepository.findStoreCardByStoreCardId(storeCardId);
    }

    @Override
    public StoreCard addStoreCard(StoreCard storeCard) {
        return storeCardRepository.save(storeCard);
    }

    @Override
    public Collection<UserCard> getAllUserCards() {
        return (Collection<UserCard>) userCardRepository.findAll();
    }

    @Override
    public Collection<UserCard> getUserCardByOpenid(String openid) {
        return userCardRepository.findUserCardsByOpenId(openid);
    }

    @Override
    public UserCard addUserCard(UserCard userCard) {
        return userCardRepository.save(userCard);
    }

    @Override
    public boolean delUserCard(int userCardId) {
        return userCardRepository.deleteUserCardByUserCardId(userCardId) == 1;
    }

    @Override
    public UserCard getUserCardByUserCardId(int userCardId) {
        return userCardRepository.findUserCardByUserCardId(userCardId);
    }

    @Override
    public Collection<CardRecord> getCardRecords() {
        return (Collection<CardRecord>) cardRecordRepository.findAll();
    }

    @Override
    public Collection<CardRecord> getCardRecordsByUserCardId(int userCardId) {
        return cardRecordRepository.findCardRecordsByUserCardId(userCardId);
    }

    @Override
    public Collection<CardRecord> getCardRecordsByUserCardIdANDDate(int userCardId, String dateStart, String dataEnd) {
        return cardRecordRepository.findCardRecordsByUserCardIdAndData(userCardId, dateStart, dataEnd);
    }

    @Override
    public Collection<Ranking> getAllRankings() {
        return rankingRepository.findAll();
    }

    @Override
    public Collection<Ranking> getAllRankingsByStoreOpenid(String storeOpenid) {
        return rankingRepository.findAllByStoreOpenid(storeOpenid);
    }

    @Override
    public Integer getRankingByUserOpenidAndStoreOpenid(String userOpenid, String storeOpenid) {
        Integer n = rankingRepository.findByUserOpenidAndStoreOpenid(userOpenid, storeOpenid);
        if (n == null) {
            return -1;
        }
        return n;
    }

    @Override
    public int getRankingNumByStoreOpenid(String storeOpenid) {
        return rankingRepository.findAllByStoreOpenid(storeOpenid).size();
    }

    @Override
    public boolean userAddRanking(String userOpenid, String storeOpenid) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = f.format(date);
        return rankingRepository.addRanking(userOpenid, storeOpenid, str) > 0;
    }

    @Override
    public Integer storeDelUserRanking(String storeOpenid) {
        return rankingRepository.deleteByStore(storeOpenid);
    }

    @Override
    public Integer getRankingByUserOpenid(String userOpenid) {
        return rankingRepository.findByUserOpenid(userOpenid);
    }

    @Override
    public Collection<Store> findStoreByUser(String userOpenid) {
        Store store = null;
        Collection<Store> stores = storeRepository.findStoreOpenidByUser(userOpenid);
        return stores;
    }


}
