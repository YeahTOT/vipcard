package com.example.vipcard.rest;

import com.example.vipcard.model.Store;
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
@RequestMapping("/vipcard/store")
public class StoreRestController {

    @Autowired
    VipCardService vipCardService;

    // 查找所有店家
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<Store>> getAllStoreTypes(){
        Collection<Store> stores;
        stores = vipCardService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    // 根据openid查找store
    // 查找所有店家
    @RequestMapping(value="/{openid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<Store>> getAllStoreTypes(@PathVariable String openid){
        Collection<Store> stores;
        stores = vipCardService.getStoresByOpenId(openid);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
}
