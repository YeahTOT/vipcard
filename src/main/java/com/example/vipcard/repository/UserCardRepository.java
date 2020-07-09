package com.example.vipcard.repository;


import com.example.vipcard.model.UserCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public interface UserCardRepository extends JpaRepository<UserCard,Integer> {
    // 查询某用户的所有会员卡
    @Query("select ucard from UserCard ucard where ucard.userOpenid = :openid")
    Collection<UserCard> findUserCardsByOpenId(@Param("openid") String openid);

    // 查询某一张会员卡
    @Query("select ucard from UserCard ucard where ucard.userCardId = :userCardId")
    UserCard findUserCardByUserCardId(@Param("userCardId") int userCardId);

    // 根据userCardId删除会员卡
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM usercard WHERE userCardId = :userCardId ")
    int deleteUserCardByUserCardId(int userCardId);

}
