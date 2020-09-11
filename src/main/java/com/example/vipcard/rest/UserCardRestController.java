package com.example.vipcard.rest;

import com.example.vipcard.model.StoreCard;
import com.example.vipcard.model.UserCard;
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
@RequestMapping("/vipcard/usercard")
public class UserCardRestController {
    @Autowired
    VipCardService vipCardService;

    // 查找所有的用户会员卡信息
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<UserCard>> findAllUserCards() {
        Collection<UserCard> userCards;
        userCards = vipCardService.getAllUserCards();
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }

    // 根据openid查询用户的所有会员卡信息
    @RequestMapping(value = "/cardByOpenId/{openid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<UserCard>> findUserCardsByOpenid(@PathVariable String openid) {
        Collection<UserCard> userCards;
        userCards = vipCardService.getUserCardByOpenid(openid);
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }

    // 根据userCardId查询该用户的某一张会员卡
    @RequestMapping(value = "/cardByUserCardId/{userCardId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserCard> findUserCardByUserCardId(@PathVariable int userCardId) {
        UserCard userCard;
        userCard = vipCardService.getUserCardByUserCardId(userCardId);
        return new ResponseEntity<>(userCard, HttpStatus.OK);
    }

    // 增加会员卡
    /*
      {
    "userOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQiIUo",
     "storeCard": {"storeCardId": 32702}
  }
     */
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<UserCard> addUserCard(@RequestBody UserCard userCard) {
        userCard = vipCardService.addUserCard(userCard);
        return new ResponseEntity<>(userCard, HttpStatus.OK);
    }

    /**
     * @param userCardId:会员卡id
     * @description: 删除会员卡
     * @return:
     * @author: JT
     * @time: 2020/6/23 15:48
     */
    @RequestMapping(value = "/{userCardId}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Boolean> delUserCard(@PathVariable int userCardId) {
        boolean key = vipCardService.delUserCard(userCardId);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }

    /**
     * @param userCardId 会员卡id
     * @description: 获取用户会员卡的二维码，包含会员卡id的信息
     * @return: org.springframework.http.ResponseEntity<byte [ ]>
     * @author: JT
     * @time: 2020/7/16 18:06
     */
    @RequestMapping(value = "/QRCode/{userCardId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<byte[]> showQRCode(@PathVariable String userCardId) {
        byte[] qrcode = null;
        try {
            qrcode = QRCode.getQRCodeImage(userCardId, 360, 360);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(qrcode, headers, HttpStatus.CREATED);
    }
}
