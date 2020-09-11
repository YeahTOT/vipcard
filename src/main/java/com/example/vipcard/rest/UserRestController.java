package com.example.vipcard.rest;

import com.example.vipcard.model.User;
import com.example.vipcard.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/vipcard/user")
public class UserRestController {
    @Autowired
    VipCardService vipCardService;

    // 查找所有的user信息
    @RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Collection<User>> findAllUsers(){
        Collection<User> users;
        users = vipCardService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // 根据userCardId查询
    @RequestMapping(value="/{userCardId}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<User> findUserByUserCardId(@PathVariable int userCardId){
        User user = vipCardService.getUserByUserCardId(userCardId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
