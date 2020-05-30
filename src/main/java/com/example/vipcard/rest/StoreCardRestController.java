package com.example.vipcard.rest;

import com.example.vipcard.model.StoreCard;
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
@RequestMapping("/vipcard/storecard")
public class StoreCardRestController {

    @Autowired
    VipCardService vipCardService;

    // 查找所有的商家会员卡信息
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<StoreCard>> findAllStoreCards(){
        Collection<StoreCard> storeCards;
        storeCards = vipCardService.getAllStoreCards();
        return new ResponseEntity<>(storeCards, HttpStatus.OK);
    }

    // 根据openid查询商家会员卡信息
    @RequestMapping(value="/{openid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<StoreCard>> findStoreCardByOpenid(@PathVariable String openid){
        Collection<StoreCard> storeCards;
        storeCards = vipCardService.getStoreCardByOpenId(openid);
        return new ResponseEntity<>(storeCards, HttpStatus.OK);
    }
}
