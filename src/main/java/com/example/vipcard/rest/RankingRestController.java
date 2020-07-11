package com.example.vipcard.rest;

import com.example.vipcard.model.Ranking;
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
@RequestMapping("/vipcard/ranking")
public class RankingRestController {

    @Autowired
    VipCardService vipCardService;

    // 查找所有的排队记录
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Ranking>> findAllRankings() {
        Collection<Ranking> rankings;
        rankings = vipCardService.getAllRankings();
        return new ResponseEntity<>(rankings, HttpStatus.OK);
    }

    // 获取排队总人数
    @RequestMapping(value = "/rankingNum/{storeOpenid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> getRankingNumByStoreOpenid(@PathVariable String storeOpenid) {
        int num = vipCardService.getRankingNumByStoreOpenid(storeOpenid);
        return new ResponseEntity<>(num, HttpStatus.OK);
    }

    // 用户获取当前排队进度
    @RequestMapping(value = "/rankingByUserOpenid/{userOpenid}/{storeOpenid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> findAllRankingsByUserOpenidAndStoreOpenid(@PathVariable String userOpenid, @PathVariable String storeOpenid) {
        Integer num = vipCardService.getRankingByUserOpenidAndStoreOpenid(userOpenid, storeOpenid);
        return new ResponseEntity<>(num, HttpStatus.OK);
    }

//     用户获取当前排队进度
    @RequestMapping(value = "/rankingByUserOpenid/{userOpenid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> findAllRankingsByUserOpenid(@PathVariable String userOpenid) {
        Integer num = vipCardService.getRankingByUserOpenid(userOpenid);
        return new ResponseEntity<>(num, HttpStatus.OK);
    }
    // 商家获取当前排队记录
    @RequestMapping(value = "/rankingByStoreOpenid/{storeOpenid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Collection<Ranking>> findAllRankingsByStoreOpenid(@PathVariable String storeOpenid) {
        Collection<Ranking> rankings = vipCardService.getAllRankingsByStoreOpenid(storeOpenid);
        return new ResponseEntity<>(rankings, HttpStatus.OK);
    }

    // 用户申请排队
    /*
    参数：用户openid 商家id
     */
    @RequestMapping(value = "/userRanking/{storeOpenid}/{userOpenid}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Boolean> userAddRanking(@PathVariable String userOpenid, @PathVariable String storeOpenid) {
        // 查询当前store的排队进度
        // 判断这个用户是否已经排队
        boolean key = false;
        Integer n = vipCardService.getRankingByUserOpenidAndStoreOpenid(userOpenid, storeOpenid);
        if (n == -1) {
            key = vipCardService.userAddRanking(userOpenid, storeOpenid);
        }
        return new ResponseEntity<>(key, HttpStatus.OK);
    }


    // 商家选择服务下一个用户，删除排名第一的记录
    @RequestMapping(value = "/delByUserOpenid/{storeOpenid}",method = RequestMethod.DELETE)
    public ResponseEntity<Collection<Ranking>> delByUserOpenid(@PathVariable String storeOpenid){
        Collection<Ranking> rankings = null;
        Integer n = vipCardService.storeDelUserRanking(storeOpenid);
        if (n > 0){
            rankings = vipCardService.getAllRankingsByStoreOpenid(storeOpenid);
        }
        return new ResponseEntity<>(rankings, HttpStatus.OK);
    }

    // 根据用户查询正在排队的商家信息
    @RequestMapping(value = "/rankingFindStoreByUser/{userOpenid}",method = RequestMethod.GET)
    public ResponseEntity<Collection<Store>> rankingFindStoreByUser(@PathVariable String userOpenid){
        Collection<Store> stores = vipCardService.findStoreByUser(userOpenid);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    // 用户取消排队
    @RequestMapping(value = "/rankingCancelByUser/{userOpenid}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> rankingCancelByUserOpenid(@PathVariable String userOpenid){
        boolean key ;
        key = vipCardService.cancelByUser(userOpenid);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }

}
