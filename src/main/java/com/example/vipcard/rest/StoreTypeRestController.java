package com.example.vipcard.rest;

import com.example.vipcard.model.StoreType;
import com.example.vipcard.model.User;
import com.example.vipcard.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping("/vipcard/storetype")
public class StoreTypeRestController {

    @Autowired
    VipCardService vipCardService;

    // 查找所有店家类型
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<StoreType>> getAllStoreTypes(){
        Collection<StoreType> storeTypes;
        storeTypes = vipCardService.getAllStoreTypes();
        return new ResponseEntity<>(storeTypes, HttpStatus.OK);
    }

    // 增加商家类型
    @RequestMapping(value="",method = RequestMethod.POST,produces="application/json")
    public ResponseEntity<StoreType> addStoreType(@RequestBody StoreType storeType){
        storeType = vipCardService.addStoreType(storeType);
        return new ResponseEntity<>(storeType, HttpStatus.OK);
    }
}
