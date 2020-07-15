// pages/personal/vipCard/record/record.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    dateStart: '2018-01-01', //默认起始时间  
    dateEnd: '2020-07-24', //默认结束时间 
    cardID: "",
    cardRecord: []
  },
  // 时间段选择  
  bindDateChange(e) {
    this.setData({
      dateStart: e.detail.value,
    })
  },
  bindDateChange2(e) {
    this.setData({
      dateEnd: e.detail.value,
    })
  },
  // 查询消费记录
  findRecord() {
    const that = this;
    //通过cardID获取交易记录
    wx.request({
      url:  app.globalData.url+'cardrecord/' + this.data.cardID + "/" + this.data.dateStart + "/" + this.data.dateEnd,
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res)
        that.setData({
          cardRecord: res.data
        })
      },
      fail: function (res) {
        console.log(res)
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const that = this;
    const cardID = options.cardID
    this.setData({
      cardID: cardID
    })
    //通过cardID获取交易记录
    wx.request({
      url:  app.globalData.url+'cardrecord/' + this.data.cardID + "/" + this.data.dateStart + "/" + this.data.dateEnd,
      method: 'GET',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res)
        that.setData({
          cardRecord: res.data
        })
      },
      fail: function (res) {
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

function initDataRecord(that) {
  that.setData({
    cardRecord: [{
        "recordType": "充值",
        "recordMoney": "+66",
        "recordDate": "2018-02-02",
        "recordTime": "16:40"
      },
      {
        "recordType": "消费",
        "recordMoney": "-66",
        "recordDate": "2019-02-02",
        "recordTime": "16:40"
      },
      {
        "recordType": "消费",
        "recordMoney": "-66",
        "recordDate": "2020-02-02",
        "recordTime": "16:40"
      },
    ]
  })
}