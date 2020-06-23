package com.example.vipcard.rest;

import com.example.vipcard.model.Store;
import com.example.vipcard.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value="/{openid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Store> getAllStoreTypes(@PathVariable String openid){
        Store stores;
        stores = vipCardService.getStoresByOpenId(openid);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    // 增加store，用于初次登录
    @RequestMapping(value="/",method = RequestMethod.POST,produces="application/json")
    public ResponseEntity<Store> addStore(@RequestBody Store store, BindingResult result){
        store = vipCardService.addStore(store);
        return new ResponseEntity<>(store, HttpStatus.CREATED);
    }

    // 更新store
    @RequestMapping(value="/",method = RequestMethod.PUT,produces="application/json")
    public ResponseEntity<Boolean> updateStore(@RequestBody Store store, BindingResult result){
        boolean key = vipCardService.updateStore(store);
        return new ResponseEntity<>(key, HttpStatus.CREATED);
    }
}
