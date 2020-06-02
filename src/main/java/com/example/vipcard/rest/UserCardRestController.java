package com.example.vipcard.rest;

import com.example.vipcard.model.StoreCard;
import com.example.vipcard.model.UserCard;
import com.example.vipcard.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/vipcard/usercard")
public class UserCardRestController {
    @Autowired
    VipCardService vipCardService;

    // 查找所有的用户会员卡信息
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<UserCard>> findAllUserCards(){
        Collection<UserCard> userCards;
        userCards = vipCardService.getAllUserCards();
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }

    // 根据openid查询用户的所有会员卡信息
    @RequestMapping(value="/cardByOpenId/{openid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<UserCard>> findStoreCardsByOpenid(@PathVariable String openid){
        Collection<UserCard> userCards;
        userCards = vipCardService.getUserCardByOpenid(openid);
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }
    // 根据userCardId查询该用户的某一张会员卡
    @RequestMapping(value="/cardByUserCardId/{userCardId}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<UserCard> findStoreCardByUserCardId(@PathVariable int userCardId){
        UserCard userCard;
        userCard = vipCardService.getUserCardByUserCardId(userCardId);
        return new ResponseEntity<>(userCard, HttpStatus.OK);
    }
}
