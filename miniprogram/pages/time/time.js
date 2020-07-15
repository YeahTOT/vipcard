// pages/time/time.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    time:"0"
  },
  start:function(){
    startTimer(this)
  },
  pause:function(){
    stopTime()
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
            time: res.data
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
function stopTime(){
  if(timer != null){
  clearTimeout(timer)
  }
}