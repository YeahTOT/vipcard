package com.example.vipcard.rest;

import com.example.vipcard.model.CardRecord;
import com.example.vipcard.model.User;
import com.example.vipcard.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/vipcard/cardrecord")
public class CardRecordRestController {

    @Autowired
    VipCardService vipCardService;

    // 查找所有的会员卡操作记录信息
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<CardRecord>> findAllCardRecords(){
        Collection<CardRecord> cardRecords;
        cardRecords = vipCardService.getCardRecords();
        return new ResponseEntity<>(cardRecords, HttpStatus.OK);
    }

    // 查找某一用户的所有会员卡记录
    @RequestMapping(value="/{userCardId}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<CardRecord>> findAllCardRecordsByUserCardId(@PathVariable int userCardId){
        Collection<CardRecord> cardRecords;
        cardRecords = vipCardService.getCardRecordsByUserCardId(userCardId);
        return new ResponseEntity<>(cardRecords, HttpStatus.OK);
    }

    // 根据时间段查找某一用户的所有会员卡记录
    @RequestMapping(value="/{userCardId}/{dateStart}/{dateEnd}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<CardRecord>> findAllCardRecordsByUserCardIdAndDate(@PathVariable int userCardId, @PathVariable String dateStart, @PathVariable String dateEnd){
        Collection<CardRecord> cardRecords;
        cardRecords = vipCardService.getCardRecordsByUserCardIdANDDate(userCardId,dateStart,dateEnd);
        return new ResponseEntity<>(cardRecords, HttpStatus.OK);
    }
}
