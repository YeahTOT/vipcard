java -jar vipcard-0.0.1-SNAPSHOT.jar    

# bug
查询ranking排序没有用
!. 需要完成预约排队的api以及前端功能
1. 需要完成会员卡等级规则，首充值金额和积分的实体类


# 进度
商家叫号
登录，讲登录信息保存在session中

   {
    "cardName": "季季红",
    "cardTypes": [
      {
             "cardTypeId": 1,
             "cardType": "储值卡"
           },
           {
             "cardTypeId": 2,
             "cardType": "积分卡"
           }
    ],
    "cardTimeStart": "2020-05-07",
    "cardTimeEnd": "2020-06-28",
    "cardStatus": "未过期",
    "cardNode": "这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这",
    "cardSurplus": 100,
    "cardNum": 200,
    "cardLogo": "https://7669-vipcard-3y6o1-1301438009.tcb.qcloud.la/image/google.png?sign\u003dd24081f06d9b12f718953b0291f95c79\u0026t\u003d1585280719",
    "store": {
      "storeOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQiIUo"
    }
  }


wx中提交请求未完成
  {
    "storeOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQisss",
    "storeUserName": "测试3",
    "storeLogo": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKAAjrpSzJE6Xx9zH9y92X4MkUZIXNTOacXFPHrvsamZ6La6SNSS5lgc8gHEtjMJta40zicicxkzyhg/132",
    "storeAddress": "南昌航空大学",
    "storePhone": "15028338677",
    "storeNode": "这个店铺是用来测试的",
    "storeName": "Yeah的店铺",
    "storeType": "服装"
  }
  
  
  // 增加userCard时的json
  
  {
    "userOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQiIUo",
     "storeCard": {"storeCardId": 32702}
  }
  {
      "userOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQiIUo",
      "cardMoney": 4.0,
      "cardScore": 80.0,
      "cardTimes": 0,
      "storeCard": {
        "storeCardId": 32702,
        "cardName": "季季红",
        "cardTypes": [
          {
            "cardType": "储值卡"
          },
          {
            "cardType": "积分卡"
          }
        ],
        "cardTimeStart": "2020-05-07",
        "cardTimeEnd": "2020-06-28",
        "cardStatus": "未过期",
        "cardNode": "这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这",
        "cardSurplus": 100,
        "cardNum": 200,
        "cardLogo": "https://7669-vipcard-3y6o1-1301438009.tcb.qcloud.la/image/google.png?sign\u003dd24081f06d9b12f718953b0291f95c79\u0026t\u003d1585280719",
        "store": {
          "storeOpenid": "oHy4O5A5cA3WAdC9YTJo8qMQiIUo"
        }
      }
    }