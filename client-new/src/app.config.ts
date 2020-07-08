export default {
  pages: [
    'pages/index/index',
    'pages/account/index',
    'pages/token/login'
  ],
  window: {
    backgroundTextStyle: 'light',
    navigationBarBackgroundColor: '#fff',
    navigationBarTitleText: 'WeChat',
    navigationBarTextStyle: 'black'
  },
  tabBar: {
    color: 'black',
    selectedColor: '#d81e06',
    backgroundColor: '#ffffff',
    borderStyle: 'white',
    list:[{
      pagePath: 'pages/index/index',
      text: '首页',
      iconPath: './assets/tabbar/indexUn@2x.png',
      selectedIconPath: './assets/tabbar/index@2x.png'
    },{
      pagePath: 'pages/account/index',
      text: '个人中心',
      iconPath: './assets/tabbar/mineUn@2x.png',
      selectedIconPath: './assets/tabbar/mine@2x.png'
    }]
  }
}
