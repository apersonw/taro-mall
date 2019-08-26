import Taro from '@tarojs/taro';

function toast(msg) {
  Taro.showToast({
    icon: 'none',
    title: msg,
  });
}

export default {
  namespace: 'net',
  state: {},
  effects: {
    * error({payload: e}, {call,}) {
      if (e.message === '401') {
        yield call(Taro.redirectTo, {url: '/pages/token/login'});
      } else {
        //解析传递过来的错误数据信息
        toast('服务器错误');
      }
    },
  },
  reducers: {
    save(state, {payload}) {
      return {...state, ...payload};
    },
  },
};
