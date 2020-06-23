package com.example.vipcard.rest;

import com.example.vipcard.model.StoreCard;
import com.example.vipcard.service.VipCardService;
import com.example.vipcard.tool.QRCode;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    @RequestMapping(value="/cardByOpenid/{openid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<StoreCard>> findStoreCardByOpenid(@PathVariable String openid){
        Collection<StoreCard> storeCards;
        storeCards = vipCardService.getStoreCardByOpenId(openid);
        return new ResponseEntity<>(storeCards, HttpStatus.OK);
    }

    // 根据openid查询商家会员卡信息
    @RequestMapping(value="/cardByStoreCardID/{storeCardID}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<StoreCard> findStoreCardByStoreCardID(@PathVariable int storeCardID){
        StoreCard storeCard;
        storeCard = vipCardService.getStoreCardById(storeCardID);
        return new ResponseEntity<>(storeCard, HttpStatus.OK);
    }

    // 商家创建会员卡
    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    public ResponseEntity<StoreCard> addStoreCard(@RequestBody StoreCard storeCard){
        System.out.println(storeCard.toString());
        storeCard = vipCardService.addStoreCard(storeCard);
        System.out.println(storeCard.toString());
        return new ResponseEntity<>(storeCard, HttpStatus.OK);
    }

    // 商家出示该会员卡的二维码，用户扫码领取会员卡
    @RequestMapping(value="/QRCode/{storeCardId}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<byte[]> showQRCode(@PathVariable String storeCardId){
        byte[] qrcode = null;
        try {
            qrcode = QRCode.getQRCodeImage(storeCardId, 360, 360);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]> (qrcode, headers, HttpStatus.CREATED);
    }
}
