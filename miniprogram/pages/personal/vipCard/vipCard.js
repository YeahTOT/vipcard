// pages/personal/vipCard/vipCard.js
const app = getApp()
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
    cardID:"",
    card:null, //会员卡
    tabCur: 0,
    iconList: [{
      image: '../../../images/tab/record.png',
      name: '充值',
      url:"record"
    }, {
      image: '../../../images/tab/charge.png',
      name: '交易记录',
      url:"./record/record"
    }, {
      image: '../../../images/tab/queue.png',
      name: '预约排队',
      url:"record"
    }],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this;
    // 通过跳转的路径获取cardID
    var cardID = options.cardID
    console.log("cardId",cardID)
    // 将cardID增加到交易记录的url上
    this.setData({
      ["iconList[1].url"]:"./record/record?cardID="+cardID
    })
    // 从全局变量中获取id
    const user = app.globalData.user
    this.setData({
        user:user
    })
    // 通过id获取card信息
    wx.request({
      url: app.globalData.url+'usercard/cardByUserCardId/'+cardID,
      method: 'GET',
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      data: {
      },
      success: function (res) {
        console.log(res.data)
        that.setData({
          card:res.data
        })
      },
      fail:function(res){
        console.log(res)
      }
    })
   
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
function fingById(cardList,id){
  for(let i = 0;i<cardList.length;i++){
    if (cardList[i].cardID == id){
      return cardList[i]
    }
  }
  return null
}
function datainit(that){
  that.setData({
   card: {
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
    "cardRecord":[
      {
        "recordType":"充值",
        "recordMoney":"+66",
        "recordDate":"2018-02-02",
        "recordTime":"16:40"
      },
      {
        "recordType":"消费",
        "recordMoney":"-66",
        "recordDate":"2019-02-02",
        "recordTime":"16:40"
      },
      {
        "recordType":"消费",
        "recordMoney":"-66",
        "recordDate":"2020-02-02",
        "recordTime":"16:40"
      },
    ]
  },
  })
}