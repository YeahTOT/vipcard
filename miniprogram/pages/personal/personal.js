// pages/personal/personal.js
const util = require('../../utils/util.js')
const app = getApp()
const db = wx.cloud.database()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //属性
    user:{
      openid:"",
      userName: "",
      userUrl: ""
    },
    ranking: "",//排队的名次，如果不存在则显示不在排队
    shopId: "",//所排队的商家的id,
    shopLogo: "",//商家logo
    shopName: "",//商家name
    vipCardList:[],//会员卡列表 对象数组
    //页面组件显示状态
    isShowVip:false,//是否展开会员卡列表 true展开
    cardStatus:"all",// 显示的什么类型的会员卡 0 已过期 1 未过期 3 全部
    cardStatus1:"textLine",// 全部样式
    cardStatus2:"",// 未过期的样式
    cardStatus3:"",// 已过期的样式
    cardName:"", // 搜索会员卡
  },

  // 查询某一张会员阿卡
  selectCard:function(){
    const that = this;
    wx.request({
      url: 'http://localhost:8080/v1/vipCard/'+this.data.user.openid,
      method: 'GET',
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      data: {
      },
      success: function (res) {
      },
      fail:function(res){
        datainitOne(that)
        console.log("一张会员卡数据加载成功")
      }
    })
  },

  //展示会员卡列表
  showVip:function(){
    if(this.data.isShowVip){
      this.setData({
        isShowVip:false
      })
    }
    else if(!this.data.isShowVip){
      this.setData({
        isShowVip:true
      })
    }
  },

  //扫描二维码
  scancode: function () {
    // 允许从相机和相册扫码
    wx.scanCode({
      success(res) {
        console.log(res);
        wx.showToast({
          title: '成功',
          icon: 'success',
          duration: 2000
        })
      },
      fail: (res) => {
        console.log(res);
        wx.showToast({
          title: '失败',
          icon: 'none',
          duration: 2000
        })
      }
    })
  },

  
 // 授权登录事件
getuserinfo(e) {
  const that = this;
  const userName = e.detail.userInfo.nickName // 管理员姓名
  const userUrl = e.detail.userInfo.avatarUrl // 头像路径
  console.log("userName",userName)
  console.log("userUrl",userUrl)
  wx.cloud.callFunction({
    name: 'getopenid',
    complete: res => {
      console.log("res",res)
      //获取用户的openid
      const openid = res.result.openid
      that.setData({
        user:{
          openid:openid,
          userName: userName,
          userUrl: userUrl
        },
      })
       // 将个人信息放到本地缓存中
       wx.setStorageSync("user", that.data.user)
       // 获取会员卡信息
       wx.request({
        url: app.globalData.url+'usercard/cardByOpenId/'+openid,
        method: 'GET',
        header: { 'content-type': 'application/x-www-form-urlencoded' },
        data: {
        },
        success: function (res) {
          console.log(res.data)
          that.setData({
            vipCardList:res.data
          })
        },
        fail:function(res){
          console.log(res)
        }
      })
    }
  })
},

  // 查看 全部 会员卡信息点击事件
  ClickCardStatus1:function(){
    this.setData({
      cardStatus:"all",//全部显示
      cardStatus1:"textLine", // 设置下划线样式
      cardStatus2:"", // 设置下划线样式
      cardStatus3:"" // 设置下划线样式
    })
  },
  // 查看 未过期 会员卡信息点击事件
  ClickCardStatus2:function(){
    this.setData({
      cardStatus:"未过期",
      cardStatus1:"", // 设置下划线样式
      cardStatus2:"textLine", // 设置下划线样式
      cardStatus3:"" // 设置下划线样式
    })
  },
  // 查看 已过期 会员卡信息点击事件
  ClickCardStatus3:function(){
    this.setData({
      cardStatus:"已过期",
      cardStatus1:"", // 设置下划线样式
      cardStatus2:"", // 设置下划线样式
      cardStatus3:"textLine" // 设置下划线样式
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(app.globalData.user)
    const that =this;
    // 如果存在个人信息，就可以直接登录
    if (app.globalData.user) {
      this.setData({
        user:{
          openid:app.globalData.user.openid,
          userName: app.globalData.user.userName,
          userUrl: app.globalData.user.userUrl,
        },
      })
     //发送请求
     // 查询该用户的所有会员卡信息
     console.log(app.globalData.url)
     wx.request({
      url: app.globalData.url+'usercard/cardByOpenId/'+app.globalData.user.openid,
      method: 'GET',
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      data: {
      },
      success: function (res) {
        console.log(res.data)
        that.setData({
          vipCardList:res.data
        })
      },
      fail:function(res){
        console.log(res)
      }
    })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})

var time = 1;
var timer;
//开启计时器
function startTimer(that) {
  timer = setTimeout(function () {
    console.log("time:"+time);
    time++;

    //发送请求
    wx.request({
      url: 'http://localhost:8080/ranking',
      method: 'POST',
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      data: {
      },
      success: function (res) {
        console.log(res)
        var resData = res.data;
        if (resData != "") {
          that.setData({
            ranking: res.data
          })
          //获取数据后重新开启定时器发送请求
          startTimer(that);

        } else {
          wx.showToast({
            title: '查询失败',
            duration: 2000
          })
        }
      }

    })

  }, 1000);
};
//停止计时器
function stopTimer(){
  if(timer != null){
  clearTimeout(timer)
  }
}

// 初始话页面数据 用于测试
function datainit(that){
  that.setData({
    vipCardList:[
      {
        "cardID":"032702",
        "logo":"https://7669-vipcard-3y6o1-1301438009.tcb.qcloud.la/image/google.png?sign=d24081f06d9b12f718953b0291f95c79&t=1585280719",
        "shopName":"季季红",
        "cardName":"季季红会员卡",
        "cardTypeList":["储值卡","积分卡"],
        "shopAddress":"江西省南昌市南昌航空大学669号旁边的乐世界二楼",
        "cardTimeStart":"2020-3-20",
        "cardTimeEnd":"2020-6-20",
        "shopPhone":"1008611",
        "cardMoney":"200",
        "cardScore":"60",
        "cardStatus":"未过期",
        "cardNode":"这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡这是用于测试的卡",
      }
    ],
  })
}