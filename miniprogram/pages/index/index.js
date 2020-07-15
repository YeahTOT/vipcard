// pages/login_test/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      name:'',
      password:''
  },
  inputName:function(e){
      this.setData({
        name:e.detail.value
      })
  },
  inputPassword: function (e) {
      this.setData({
        password: e.detail.value
      })
  },
  submitButton:function(){
    console.log("点击按钮!" + "获取到的用户名:" + this.data.username + "获取到的密码:" + this.data.password)
      var that = this;

      wx.request({
        url: 'http://localhost:8080/wxlogin',
          method:'POST',
          header:{'content-type':'application/x-www-form-urlencoded'},
          data:{
            'name': that.data.name,
            'password': that.data.password
          },
          success:function(res){
              console.log(res)
              var resData = res.data;
              if(resData != ""){
                  wx.showToast({
                      title: '登录成功',
                      duration:2000
                  })
              }else{
                  wx.showToast({
                      title: '登录失败',
                      duration:2000
                  })
              }
          }

      })


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
