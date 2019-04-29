export default [
  // user
  {
    path: '/user',
    component: '../layouts/UserLayout',
    routes: [
      { path: '/user', redirect: '/user/login' },
      { path: '/user/login', name: 'login', component: './User/Login' },
      { path: '/user/register', name: 'register', component: './User/Register' },
      {
        path: '/user/register-result',
        name: 'register.result',
        component: './User/RegisterResult',
      },
    ],
  },
  // app
  {
    path: '/',
    component: '../layouts/BasicLayout',
    Routes: ['src/pages/Authorized'],
    routes: [
      // dashboard
      { path: '/', redirect: '/dashboard/analysis' },
      {
        path: '/dashboard',
        name: 'dashboard',
        icon: 'dashboard',
        routes: [
          {
            path: '/dashboard/analysis',
            name: 'analysis',
            component: './Dashboard/Analysis',
          },
          {
            path: '/dashboard/monitor',
            name: 'monitor',
            component: './Dashboard/Monitor',
          },
          {
            path: '/dashboard/workplace',
            name: 'workplace',
            component: './Dashboard/Workplace',
          },
        ],
      },
      //用户管理
      {
        path: '/member',
        name: 'member',
        icon: 'table',
        routes: [
          {
            path: '/member/userList',
            name: 'userList',
            component: './Member/UserTableList',
          },
        ],
      },
      //资源管理
      {
        path: '/link',
        name: 'link',
        icon: 'table',
        routes: [
          {
            path: '/link/linkList',
            name: 'linkList',
            component: './Link/LinkTableList',
          },
        ],
      },
      //会员卡管理
      {
        path: '/vipCard',
        name: 'vipCard',
        icon: 'table',
        routes: [
          {
            path: '/vipCard/vipCardList',
            name: 'vipCardList',
            component: './VipCard/TableList',
          },
          {
            path: '/vipCard/interestList',
            name: 'interestList',
            component: './VipCard/InterestTableList',
          },
          {
            path: '/vipCard/couponList',
            name: 'couponList',
            component: './VipCard/CouponTableList',
          },
        ],
      },
      //商品管理
      {
        path: '/goods',
        name: 'goods',
        icon: 'table',
        routes: [
          {
            path: '/goods/goodsList',
            name: 'goodsList',
            component: './Goods/GoodsTableList',
          },
          {
            path: '/goods/goodsSaveForm',
            name: 'goodsSaveForm',
            component: './Goods/Forms/GoodsSaveForm',
            hideInMenu: true,
          },
          {
            path: '/goods/categoryList',
            name: 'categoryList',
            component: './Goods/CategoryTableList',
          },
          {
            path: '/goods/brandList',
            name: 'brandList',
            component: './Goods/BrandTableList',
          },
        ],
      },
      //订单管理
      {
        path: '/order',
        name: 'order',
        icon: 'table',
        routes: [
          {
            path: '/order/orderList',
            name: 'orderList',
            component: './Order/OrderTableList',
          },
        ],
      },
      //店铺管理
      {
        path: '/shop',
        name: 'shop',
        icon: 'table',
        routes: [
          {
            path: '/shop/shopList',
            name: 'shopList',
            component: './Shop/TableList',
          },
        ],
      },
      //主题管理
      {
        path: '/theme',
        name: 'theme',
        icon: 'table',
        routes: [
          {
            path: '/theme/themeList',
            name: 'themeList',
            component: './Theme/TableList',
          },
        ],
      },
      //秒杀管理
      {
        path: '/spike',
        name: 'spike',
        icon: 'table',
        routes: [
          {
            path: '/spike/spikeList',
            name: 'spikeList',
            component: './Spike/TableList',
          },
        ],
      },
      //推荐管理
      {
        path: '/recommend',
        name: 'recommend',
        icon: 'table',
        routes: [
          {
            path: '/recommend/recommendList',
            name: 'recommendList',
            component: './Recommend/TableList',
          },
        ],
      },
      // forms
      {
        path: '/form',
        icon: 'form',
        name: 'form',
        hideInMenu: true,
        routes: [
          {
            path: '/form/basic-form',
            name: 'basicform',
            component: './Forms/BasicForm',
          },
          {
            path: '/form/step-form',
            name: 'stepform',
            component: './Forms/StepForm',
            hideChildrenInMenu: true,
            routes: [
              {
                path: '/form/step-form',
                redirect: '/form/step-form/info',
              },
              {
                path: '/form/step-form/info',
                name: 'info',
                component: './Forms/StepForm/Step1',
              },
              {
                path: '/form/step-form/confirm',
                name: 'confirm',
                component: './Forms/StepForm/Step2',
              },
              {
                path: '/form/step-form/result',
                name: 'result',
                component: './Forms/StepForm/Step3',
              },
            ],
          },
          {
            path: '/form/advanced-form',
            name: 'advancedform',
            authority: ['admin'],
            component: './Forms/AdvancedForm',
          },
        ],
      },
      // list
      {
        path: '/list',
        icon: 'table',
        name: 'list',
        hideInMenu: true,
        routes: [
          {
            path: '/list/table-list',
            name: 'searchtable',
            component: './List/TableList',
          },
          {
            path: '/list/basic-list',
            name: 'basiclist',
            component: './List/BasicList',
          },
          {
            path: '/list/card-list',
            name: 'cardlist',
            component: './List/CardList',
          },
          {
            path: '/list/search',
            name: 'searchlist',
            component: './List/List',
            routes: [
              {
                path: '/list/search',
                redirect: '/list/search/articles',
              },
              {
                path: '/list/search/articles',
                name: 'articles',
                component: './List/Articles',
              },
              {
                path: '/list/search/projects',
                name: 'projects',
                component: './List/Projects',
              },
              {
                path: '/list/search/applications',
                name: 'applications',
                component: './List/Applications',
              },
            ],
          },
        ],
      },
      {
        path: '/profile',
        name: 'profile',
        icon: 'profile',
        hideInMenu: true,
        routes: [
          // profile
          {
            path: '/profile/basic',
            name: 'basic',
            component: './Profile/BasicProfile',
          },
          {
            path: '/profile/basic/:id',
            name: 'basic',
            hideInMenu: true,
            component: './Profile/BasicProfile',
          },
          {
            path: '/profile/advanced',
            name: 'advanced',
            authority: ['admin'],
            component: './Profile/AdvancedProfile',
          },
        ],
      },
      {
        name: 'result',
        icon: 'check-circle-o',
        path: '/result',
        hideInMenu: true,
        routes: [
          // result
          {
            path: '/result/success',
            name: 'success',
            component: './Result/Success',
          },
          { path: '/result/fail', name: 'fail', component: './Result/Error' },
        ],
      },
      {
        name: 'exception',
        icon: 'warning',
        path: '/exception',
        hideInMenu: true,
        routes: [
          // exception
          {
            path: '/exception/403',
            name: 'not-permission',
            component: './Exception/403',
          },
          {
            path: '/exception/404',
            name: 'not-find',
            component: './Exception/404',
          },
          {
            path: '/exception/500',
            name: 'server-error',
            component: './Exception/500',
          },
          {
            path: '/exception/trigger',
            name: 'trigger',
            hideInMenu: true,
            component: './Exception/TriggerException',
          },
        ],
      },
      {
        name: 'account',
        icon: 'user',
        path: '/account',
        hideInMenu: true,
        routes: [
          {
            path: '/account/center',
            name: 'center',
            component: './Account/Center/Center',
            routes: [
              {
                path: '/account/center',
                redirect: '/account/center/articles',
              },
              {
                path: '/account/center/articles',
                component: './Account/Center/Articles',
              },
              {
                path: '/account/center/applications',
                component: './Account/Center/Applications',
              },
              {
                path: '/account/center/projects',
                component: './Account/Center/Projects',
              },
            ],
          },
          {
            path: '/account/settings',
            name: 'settings',
            component: './Account/Settings/Info',
            routes: [
              {
                path: '/account/settings',
                redirect: '/account/settings/base',
              },
              {
                path: '/account/settings/base',
                component: './Account/Settings/BaseView',
              },
              {
                path: '/account/settings/security',
                component: './Account/Settings/SecurityView',
              },
              {
                path: '/account/settings/binding',
                component: './Account/Settings/BindingView',
              },
              {
                path: '/account/settings/notification',
                component: './Account/Settings/NotificationView',
              },
            ],
          },
        ],
      },
      {
        component: '404',
      },
    ],
  },
];
